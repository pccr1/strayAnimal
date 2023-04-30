<template>
    <el-container>
        <el-header>
            <el-row>
                <el-button 
                icon="el-icon-arrow-left" 
                @click="$router.back()" 
                style="border: none"
                round></el-button>

                
            </el-row>

            <span style="font-weight: bold;">发帖</span>
                
            <div style="float:right">
                <el-button 
                @click="fabu()" 
                style="border: none"
                round>发布</el-button>
            </div>
        </el-header>

        <div class="el-main">
            <!-- 照片 -->
            <div style="float: left;" >
                <el-upload
                :class="{picUploader: infopics.length>=9}"
                action="#"
                :before-upload="handleInfoPic"
                :on-success="handleSuccess"
                :http-request="submitUpload"
                list-type="picture-card"
                :file-list="showPicList"
                >
                <i v-if="infopics.length<9" slot="default" class="el-icon-plus" />
                <div slot="file" slot-scope="{ file }">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
                    <span class="el-upload-list__item-actions">
                    <span
                        class="el-upload-list__item-preview"
                        @click="handlePictureCardPreview(file)"
                    ><i class="el-icon-zoom-in" /></span>
                    <span
                        class="el-upload-list__item-delete"
                        @click="handleRemove(file)"
                    ><i class="el-icon-delete" /></span>
                    </span>
                </div>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible" append-to-body title="图片预览">
                <img width="100%" :src="dialogImageUrl" alt="" />
                </el-dialog>
            </div>
            <!-- 标题 -->
            <el-input ref="biaoti" v-model="text" placeholder="请输入标题"></el-input>

            <!-- 正文 -->
            <el-input
            ref="zhengwen"
            type="textarea"
            :rows="20"
            placeholder="请输入正文"
            v-model="textarea">
            </el-input>
        </div>

        <el-footer>
            <el-popover
            style="float:left"
            placement="bottom"
            width="200"
            trigger="click">
            <ul class="list">
                <li v-for="i in emojis" :key="i" class="list-item">
                    <el-button 
                    @mousedown.native="addEmojiMousedown($event,i)" 
                    size="mini" 
                    style="border:none" 
                    circle>{{ i }}</el-button>
                </li>
            </ul>
            
            <el-button 
            slot="reference" 
            @mousedown.native="showEmojiMousedown($event)" 
            size="mini" 
            style="border:none" 
            circle>😀</el-button>
            </el-popover>
        </el-footer>
    </el-container>
</template>

<script>
    export default {
        name:"AddPost",
        data() {
            return{
                emojis: ["😀", "😁", "😂", "🤣", "😃", "😄", "😅", "😆", "😉", "😊", "😋", "😎", "😍", "😘", "😗", "😙", "😚","🥵","😭","🤡"],
                text:'',//标题
                textarea:'',//正文
                dialogImageUrl: '', // 图片操作对话框上的图片
                dialogVisible: false, // 图片操作对话框可见性
                infopics: [], // 所需上传图片组 => 存储base64
                picName: '', // 图片名称
                showPicList: [], // 所需展示图片组 => 存储图片文件
                cooid:null,//暂存帖子id
                push:false,
                images: [],//图片上传
            }
        },
        methods: {
            fabu() {//发布帖子
                if (this.text === ''){
                    console.log(this.showPicList)
                    this.$message.error('标题不能为空');
                }else if (this.textarea === ''){
                    this.$message.error('内容不能为空');
                }else {
                    const formData = new FormData()
                    formData.append('userId', this.$cookie.get('userId'))
                    formData.append('postHeadline', this.text)
                    formData.append('postText', this.textarea)

                    const fullUrl = this.$myVariable + 'post/info/addPostInfo';
                    this.$axios.post(fullUrl, formData,{
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        }
                    })
                    .then(response => {
                        this.push = true
                        this.cooid = Number(response.data.object)
                    })
                    .catch(error => {
                        console.log(error);
                    });

                    for(let i = 0 ; i < this.showPicList.length ; i++){
                        this.saveImageMousedown1(i)
                        .then(url => {
                            this.saveImageMousedown2(url)
                        })
                        .catch(error => {
                            // 处理错误
                            console.log(error);
                        });
                    }
                    if(!this.push){
                        // 弹出提示
                        this.push = false
                        // this.$forceUpdate();
                        this.$message({
                            message: '发送成功',
                            type: 'success'
                        });
                        this.$router.back()
                    }else{
                        this.$message.error('发送失败');
                    }
                }
            },
            saveImageMousedown1(i) {
                return new Promise((resolve, reject) => {
                    const formData = new FormData()
                    formData.append('image', this.images[i])

                    const fullUrl = this.$myVariable + 'upload';
                    this.$axios.post(fullUrl, formData,{
                            headers: {
                                'Content-Type': 'multipart/form-data'
                            }
                        })
                        .then(response => {
                            // console.log(response.data.object)
                            resolve(response.data.object)
                        })
                        .catch(error => {
                            console.log(error);
                            reject(error)
                        });
                });
            },
            saveImageMousedown2(url) {
                if (url != '') {
                    const formData = new FormData()
                    formData.append('postId', this.cooid)
                    // console.log(url)
                    formData.append('pictureUrl', url)

                    const fullUrl = this.$myVariable + 'picture/info/addPicture';
                    this.$axios.post(fullUrl, formData,{
                            headers: {
                                'Content-Type': 'multipart/form-data'
                            }
                        })
                        .then(response => {
                            console.log(response.data);
                        })
                        .catch(error => {
                            console.log(error);
                        });
                }
            },
            // 0.3.1 上传图片 => 点击上传触发
            handleInfoPic(file) {
                const isJPG = file.type === 'image/jpeg';
                const isJPG2 = file.type === 'image/jpg';
                const isPNG = file.type === 'image/png';
                if (!isJPG && !isJPG2 && !isPNG) this.$message.error('请上传格式为 png, jpg, jpeg 的图片！');
                this.picName = file.name;

                this.images.push(file);
                console.log(this.images)

                return isJPG || isJPG2 || isPNG;
            },
            // 0.3.2 提交请求
            submitUpload(content) {
                content.onSuccess();
            },
            // 0.3.3 图片上传成功加入数据
            handleSuccess(response, file, fileList) {
                this.showPicList = fileList;
                const reader = new FileReader();
                reader.readAsDataURL(file.raw); // 图片文件转 base64
                reader.onload = () => {
                    this.infopics.push({
                    name: this.picName,
                    url: reader.result
                    })
                };
            },
            // 0.3.4 图片移除操作
            handleRemove(file) {
                const indexShow = this.showPicList.findIndex((el) => el.name === file.name);
                this.showPicList = this.showPicList
                    .slice(0, indexShow)
                    .concat(this.showPicList.slice(indexShow + 1, this.showPicList.length));
                const index = this.infopics.findIndex((el) => el.name === file.name);
                this.infopics = this.infopics
                    .slice(0, index)
                    .concat(this.infopics.slice(index + 1, this.infopics.length));
            },
            // 0.3.5 图片浏览操作
            handlePictureCardPreview(file) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            },
            showEmojiMousedown(event){
                event.preventDefault();
                
            },
            addEmojiMousedown(event,i){
                event.preventDefault();
                const activeElement = document.activeElement
                if (activeElement === this.$refs.biaoti.$el.querySelector('input')) {
                    this.text += i
                }else if (activeElement === this.$refs.zhengwen.$el.querySelector('textarea')) {
                    this.textarea += i
                }
            },
        },
        mounted() {
            if(!this.$cookie.get('userId')){
                this.$confirm('当前还未登录哦，是否前往登录?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
                }).then(() => {
                    this.$router.push({name:'login'})
                }).catch(() => {
                    this.$message({
                    type: 'info',
                    message: '已取消'
                });   
                this.$router.back()    
                });
            }
        },
    }
    
</script>

<style scoped>
    .el-row {
        float: left;
    }
    .el-header {
        width: 400px;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    .el-main {
        width: 100%;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        height: 680px;
    }
    .el-footer {
        width: 400px;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    .el-main>>>.el-input__inner {
        border: 0;
    }
    .el-main>>>.el-textarea__inner {
        border: 0;
        resize: none;/* 这个是去掉 textarea 下面拉伸的那个标志，如下图 */
    }
    .picUploader >>> .el-upload--picture-card {
        display: none;
    }
    .list {
        display: flex;
        list-style: none;
        flex-wrap: wrap;
        padding: 0;
        margin: 0;
    }
    .list-item {
        margin-right: 10px;
    }
</style>