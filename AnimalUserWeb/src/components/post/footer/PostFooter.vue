<template>
    <el-footer >
        <div v-if="imageList.length>0" class="image-list-container">
            <div class="image-list" v-for="(image, index) in imageList" :key="index">
                <el-image  :src="image" style=" height: 50px;" ></el-image>
                <button class="delete-btn" @click="deleteImage(index)">×</button>
            </div>
        </div>
        <!-- <div style="margin: 20px 0;"></div> -->
        
        <div class="text-editor">
            <el-col :span="14">
                <el-input
                ref="wenben"
                type="textarea"
                :placeholder=textOn
                v-model="text"
                maxlength="255"
                rows="1"
                @focus="handleFocus"
                @blur="handleBlur"
                >
                </el-input>
            </el-col>
            <div class="button-group">
                <!-- 表情 -->
                <el-popover
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
                    v-show="isFirstButtonVisible" 
                    @mousedown.native="showEmojiMousedown($event)" 
                    size="mini" 
                    style="border:none" 
                    circle>😀</el-button>
                </el-popover>

                <!-- 图片 -->
                <el-upload
                class="image-upload"
                action=""
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
                >
                    <el-button 
                    slot="trigger"
                    icon="el-icon-circle-plus-outline" 
                    v-if="isSecondButtonVisible" 
                    style="border:none" 
                    @mousedown.native="addImageMousedown($event)" 
                    circle></el-button>
                <!-- <el-button slot="trigger" size="small" type="primary">选取图片</el-button> -->
                </el-upload>

                <!-- 保存 -->
                <el-button 
                icon="el-icon-top" 
                v-if="isThirdButtonVisible" 
                style="border:none"
                @mousedown.native="saveTextAndImageMousedown($event)" 
                circle></el-button>
            </div>
        </div>
        <div class="coli" v-show="!isFirstButtonVisible">
            <el-button 
            size="mini" 
            icon="el-icon-star-off" 
            v-show="!collect" 
            @click="
            collect=!collect" 
            style="border:none" 
            circle>收藏</el-button>
            <el-button 
            size="mini" 
            type="warning" 
            icon="el-icon-star-off" 
            v-show="collect" 
            @click="collect=!collect" 
            style="border:none"
            circle>已收藏</el-button>
            <el-button 
            size="mini" 
            icon="el-icon-thumb" 
            v-show="!like" 
            @click="like=!like" 
            style="border:none"
            circle>点赞</el-button>
            <el-button 
            size="mini" 
            type="warning" 
            icon="el-icon-thumb" 
            v-show="like" 
            @click="like=!like" 
            style="border:none"
            circle>已赞</el-button> 
        </div>
    </el-footer>
</template>

<script>
    export default {
        name:'PostFooter',
        data() {
            return {
                push: false,
                Obj:'',//暂存评论信息
                Objbu: false,
                Huifu:'',//暂存回复信息
                Huifubu: false,
                attention: false,//关注
                collect: false,//收藏
                like: false,//点赞
                text: '',
                textOn:'请输入内容',//文本框默认显示
                imageList: [],//处理后图片
                images:[],//原版
                url:'',//暂存图片网址
                cooid:null,//暂存评论id
                isFocus:false,
                isThirdButtonVisible : false,
                isFirstButtonVisible : false,
                isSecondButtonVisible : false,
                showEmojis:false,
                emojis: ["😀", "😁", "😂", "🤣", "😃", "😄", "😅", "😆", "😉", "😊", "😋", "😎", "😍", "😘", "😗", "😙", "😚","🥵","😭","🤡"],
            }
        },
        computed: {
            isTextOrImageExist() {
                return this.text.trim() !== '' || this.imageList.length > 0
            },
        },
        methods: {
            showEmojiMousedown(event){
                event.preventDefault();
                
            },
            addEmojiMousedown(event,i){
                event.preventDefault();
                this.text += i
            },
            addImageMousedown(event) {
                event.preventDefault();
                // 实现添加图片的逻辑
                
                // 将添加的图片链接添加到 this.imageList 数组中
            },
            handleAvatarSuccess() {
                // this.imageList.push(response.data.url)
            },
            beforeAvatarUpload(file) {
                // const isJPG = file.type === 'image/jpeg';
                // const isLt2M = file.size / 1024 / 1024 < 2;
                // if (!isJPG) {
                //     this.$message.error('上传头像图片只能是 JPG 格式!');
                //     return false;
                // }
                // if (!isLt2M) {
                //     this.$message.error('上传头像图片大小不能超过 2MB!');
                //     return false;
                // }
                this.images.push(file)
                const reader = new FileReader()
                reader.onload = event => {
                this.imageList.push(event.target.result)
                }
                reader.readAsDataURL(file)
                return false;
            },
            saveTextAndImageMousedown(event) {
                event.preventDefault();
                // 实现保存文本和图片的逻辑
                if(this.text === ''){
                    this.$message.error('不能发送空的内容');
                }else{
                    if(this.textOn === '请输入内容')
                    {
                        const formData = new FormData()
                        formData.append('postId', this.$cookie.get('postId'))
                        formData.append('userId', this.$cookie.get('userId'))
                        formData.append('commentText', this.text)

                        const fullUrl = this.$myVariable + 'comment/info/insertCommentInfo';
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

                        for(let i = 0 ; i < this.images.length ; i++){
                            this.saveImageMousedown1(i)
                            .then(url => {
                                this.saveImageMousedown2(url)
                            })
                            .catch(error => {
                                // 处理错误
                                console.log(error);
                            });
                        }
                    }else{
                        if(this.Objbu){
                            const formData = new FormData()
                            formData.append('commentId', this.Obj.commentId)
                            formData.append('answerUserId', this.$cookie.get('userId'))
                            formData.append('toBeAnswerUserId', this.Obj.userId)
                            formData.append('answerText', this.text)

                            const fullUrl = this.$myVariable + 'answer/info/addAnswerInfo';
                            this.$axios.post(fullUrl, formData,{
                                headers: {
                                    'Content-Type': 'multipart/form-data'
                                }
                            })
                            .then(response => {
                                this.push = true
                                console.log(response.data.object)
                            })
                            .catch(error => {
                                console.log(error);
                            });
                        }
                        if(this.Huifubu){
                            const formData = new FormData()
                            formData.append('commentId', this.Huifu.commentId)
                            formData.append('answerUserId', this.$cookie.get('userId'))
                            formData.append('toBeAnswerUserId', this.Huifu.answerUserId)
                            formData.append('answerText', this.text)

                            const fullUrl = this.$myVariable + 'answer/info/addAnswerInfo';
                            this.$axios.post(fullUrl, formData,{
                                headers: {
                                    'Content-Type': 'multipart/form-data'
                                }
                            })
                            .then(response => {
                                this.push = true
                                console.log(response.data.object)
                            })
                            .catch(error => {
                                console.log(error);
                            });
                        }
                    }
                    this.text = '';
                    this.imageList = [];
                    this.images = [];
                    if(!this.push){
                        // 弹出提示
                        this.push = false
                        // this.$forceUpdate();
                        this.$message({
                            message: '发送成功',
                            type: 'success'
                        });
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
                    formData.append('commentId', this.cooid)
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
            handleFocus(e) {
                this.isFocus = true;
                this.handleInput();
                if(!this.$cookie.get('userId')){
                    e.srcElement.blur();
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
                    });
                }
            },
            handleBlur() {
                this.isFocus = false;
                this.textOn = '请输入内容'
                this.Obj = ''
                this.Huifu = ''
                this.Objbu = false
                this.Huifubu = false
                this.handleInput();
            },
            handleInput() {
                // 只有当文本框获取焦点时，前两个按钮才可见
                if (this.isFocus) {
                    if(this.textOn === '请输入内容'){
                        this.isThirdButtonVisible = false;
                        this.isFirstButtonVisible = true;
                        this.isSecondButtonVisible = true;
                        // 当文本框内有输入，或者添加了图片时，第三个按钮可见，前两个按钮也可见
                        if (this.text || this.imageList.length > 0) {
                            this.isThirdButtonVisible = true;
                            this.isFirstButtonVisible = true;
                            this.isSecondButtonVisible = true;
                        }
                    }else{
                        this.isThirdButtonVisible = false;
                        this.isFirstButtonVisible = true;
                        this.isSecondButtonVisible = false;
                        // 当文本框内有输入，或者添加了图片时，第三个按钮可见，前两个按钮也可见
                        if (this.text || this.imageList.length > 0) {
                            this.isThirdButtonVisible = true;
                            this.isFirstButtonVisible = true;
                            this.isSecondButtonVisible = false;
                        }
                    }
                } else {
                    this.isThirdButtonVisible = false;
                    this.isFirstButtonVisible = false;
                    this.isSecondButtonVisible = false;
                }        
            },
            deleteImage(index) {
                this.imageList.splice(index, 1);
            },
            demo (Obj) {
                this.textOn = '回复 ' + Obj.userNetWorkName
                this.Obj = Obj
                this.Objbu = true
                this.Huifubu = false
                // 获取文本框的 DOM 引用
                const inputElement = this.$refs.wenben;
                // 调用文本框的 focus() 方法
                inputElement.focus();
            },
            demo1 (reply1,Huifu) {
                this.textOn = '回复 ' + reply1
                this.Huifu = Huifu
                this.Huifubu = true
                this.Objbu = false
                // 获取文本框的 DOM 引用
                const inputElement = this.$refs.wenben;
                // 调用文本框的 focus() 方法
                inputElement.focus();
            },
        },
        mounted() {
            // 监听文本框的输入状态
            this.$bus.$on('textClicked',this.demo)
            this.$bus.$on('textClicked1',this.demo1)
            this.$refs.wenben.$el.addEventListener('input', this.handleInput);
        },
        beforeDestroy() {
            this.$bus.$off("textClicked")
            this.$bus.$off("textClicked1")
        }
    }
    
</script>

<style scoped>
    .el-col {
        line-height: 50px
    }
    .coli {
        float: right;
        z-index: 1;
    }
    .text-editor {
        position: relative;
        width: 100%;
        z-index: 1;
    }
    .button-group {
        display: flex;
        justify-content: flex-end;
        position: absolute;
        top: 0;
        right: 0;
    }
    .image-list {
        display: flex;
        margin-right: 10px;
        margin-bottom: 10px;
        position: relative;
        display: flex;
        flex-wrap: wrap;
        gap: 8px;
        height: 50px;
        /* width: 100%; */
        /* position: absolute; */
        /* top: -50px; */
        padding-bottom: 8px;
    }
    .image-list-container {
        display: flex;
        flex-wrap: wrap;
        position: absolute;
        top : 700px;
        z-index: 999;
        /* width: 360px; */
        /* background-color: #FFFFFF; */
        /* margin: 50px 0; */
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
    .delete-btn {
        position: absolute;
        top: 0;
        right: 0;
        display: flex;
        width: 10px;
        height: 10px;
        border-radius: 50%;
        background-color: red;
        border: none;
        cursor: pointer;
        justify-content: center;
        align-items: center;
        color: #FFFFFF;
    }
    .image-list:last-child {
        margin-right: 0;
    }
</style>