<template>
    <div class="list-view-layout">
        <json-filter>
            <el-form slot="form" :inline="true" @submit.native.prevent>
                <el-form-item label="活动名称：">
                    <el-input v-model="voluntaryActivityName" placeholder="请输入内容"></el-input>
                </el-form-item>
                <el-form-item label="志愿者姓名：">
                    <el-input v-model="userRealname" placeholder="请输入内容"></el-input>
                </el-form-item>
                <el-form-item label=" 活动状态：">
                    <el-select placeholder="请选择活动状态" v-model="status">
                        <el-option label="全部" value=""></el-option>
                        <el-option label="未开始 " value="未开始 "></el-option>
                        <el-option label="进行中" value="进行中"></el-option>
                        <el-option label="已结束" value="已结束"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="buttons">
                <el-button type="primary" @click="daochu">导出</el-button>
                <el-button plain @click="searchonly">查询</el-button>
                <el-button type="primary">添加</el-button>
            </div>
        </json-filter>
        <json-table ref="myJsonTable" :table-heads="tableHeads" :table-data="tableData" :page="page"
            @current-change="currentPageChange" @size-change="sizeChange">
            <template #usable="iData">
                <json-status :status="iData.rowData.scope.row.usable ? 'success' : 'error'"
                    :text="iData.rowData.scope.row.usable ? '启用' : '禁用'"></json-status>
            </template>
            <template #operations="iData">
                <el-button type="text" @click="doWatch(iData.rowData.scope.row)">详情</el-button>
                <el-button type="text" @click="doDelete(iData.rowData.scope.row)">删除</el-button>
            </template>
        </json-table>
        <el-dialog title="详情" :visible.sync="dialogVisible" width="40%">
            <h3>活动详情</h3>
            <el-form>
                <el-form-item>
                    <el-input type="textarea" :rows="4" placeholder="活动详情"
                        v-model="voluntaryActivityDetailedInformation">

                    </el-input>

                </el-form-item>
                <br><br>
                <br>
                <el-form-item>
                    <el-button type="primary" @click="edit1">编辑</el-button>
                </el-form-item>
            </el-form>
            <el-divider></el-divider>
            <h3>参加人员</h3>
            <el-table :data="tableData1" style="width: 100%" border>
                <el-table-column prop="volunteerId" label="参加人员ID">

                </el-table-column>
                <el-table-column prop="userRealname" label="姓名">

                </el-table-column>
                <el-table-column prop="volunteerTitle" label="称号">

                </el-table-column>
                <el-table-column fixed="right" label="操作">
                    <template slot-scope="scope">
                        <el-button @click="deleteVolun(scope.row)" type="text">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="addVolunteer">添加</el-button>
            </span>
        </el-dialog>
        <el-dialog title="添加参加活动的志愿者" :visible.sync="vs" width="20%" :close-on-click-modal="false">
            <el-form>
                <el-form-item label="志愿者ID">
                    <el-input v-model="volunteerId1"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="userRealname1"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit1">添加</el-button>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="vs = false">取 消</el-button>
                <el-button type="primary" @click="onSubmit1">确 定</el-button>
            </span>
        </el-dialog>


        <el-dialog title="活动编辑" :visible.sync="vs11" width="30%">
            <el-form>
                <el-form-item label="活动名称：">
                    <el-input v-model="form.voluntaryActivityName"></el-input>
                </el-form-item>
                <el-form-item label="活动时间：">
                    <el-col :span="9">
                        <el-date-picker type="date" placeholder="选择日期" v-model="form.voluntaryActivityTime"
                            style="width:100%;"></el-date-picker>
                    </el-col>

                </el-form-item>
                <el-form-item label="活动地址：">
                    <el-input v-model="form.voluntaryActivityAddress"></el-input>
                </el-form-item>
                <el-form-item label="活动状态：">
                    <el-select v-model="form.status" placeholder="请选择活动状态">
                      <el-option label="未开始" value="未开始"></el-option>
                      <el-option label="进行中" value="进行中"></el-option>
                      <el-option label="已结束" value="已结束"></el-option>
                    </el-select>
                  </el-form-item>
                <el-form-item label="最大活动人数：">
                    <el-input v-model="form.voluntaryActivityPeopleNumble"></el-input>
                </el-form-item>
                <el-form-item label="活动详细信息：">
                    <el-input type="textarea" :rows="2" placeholder="活动详细信息："
                        v-model="form.voluntaryActivityDetailedInformation">
                    </el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="vs11 = false">取 消</el-button>
                <el-button type="primary" @click="updateActivity">修改</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
    import JsonFilter from "@/components/JsonFilter";
    import JsonTable from "@/components/JsonTable";
    import { selectVoluntaryActivityInfo, selectVoluntaryActivityDetailedInformation, 
        selectVolunteer, deleteVolunteer, addVolunteer,updateVoluntaryActivity,deleteVoluntaryActivity} from "@/api/voluntaryActivity.js";
    export default {
        components: { JsonFilter, JsonTable },
        data() {
            return {

                load: false,
                load1: false,
                form: {
                    voluntaryActivityName: "",
                    voluntaryActivityAddress: "",
                    voluntaryActivityTime: "",
                    status: "",
                    voluntaryActivityPeopleNumble: "",
                    voluntaryActivityDetailedInformation:""
                },
                vs11: false,
                volunteerId: "",
                volunteerId1: "",
                userRealname: "",
                userRealname1: "",
                tableData1: [],
                vs: false,
                voluntaryActivityDetailedInformation: "",
                voluntaryActivityId: "",
                voluntaryActivityId1: "",
                dialogVisible: false,
                status: "",
                voluntaryActivityName: "",
                userRealname: "",
                tableData: [/*{
                    voluntaryActivityId: "1",
                    voluntaryActivityName: "喂养流浪动物",
                    voluntaryActivityTime: "2023-1-31",
                    voluntaryActivityAddress: "临沂大学",
                    voluntaryActivityPeopleNumble: "50"
                }*/],
                page: {
                    limit: 20,
                    current: 1,
                    total: 20,
                },
                chooseEntity: null,




                tableHeads: [{
                    prop: "voluntaryActivityId",
                    label: "活动ID"
                },
                {
                    prop: "voluntaryActivityName",
                    label: "活动名称"
                },
                {
                    prop: "strVoluntaryActivityTime",
                    label: "活动时间"
                }, {
                    prop: "voluntaryActivityAddress",
                    label: "活动地址"
                },
                {
                    prop: "voluntaryActivityPeopleNumble",
                    label: "最大活动人数"
                },
                {
                    slot: true,
                    prop: "operations",
                    label: "操作",
                }
                ],

                formData: {

                },
            }
        },
        methods: {
            doDelete(){
                deleteVoluntaryActivity({voluntaryActivityId:this.voluntaryActivityId}).then((res)=>{ 
                     if(res.success){
                        this.$message.success("删除成功");
                        this.getTabledata()
                     }else{
                        this.$message.warning("删除失败，请稍后再试")
                     }
                })
            },
            updateActivity(){

                updateVoluntaryActivity({
                    voluntaryActivityId:this.voluntaryActivityId,
                    voluntaryActivityName:this.form.voluntaryActivityName,
                    voluntaryActivityAddress:this.form.voluntaryActivityAddress,
                    voluntaryActivityTime:this.form.voluntaryActivityTime,
                    voluntaryActivityPeopleNumble:this.form.voluntaryActivityPeopleNumble,
                    status:this.form.status,
                    voluntaryActivityDetailedInformation:this.form.voluntaryActivityDetailedInformation}).then((res)=>{
                          if(res.success){
                             this.$message.success("编辑成功")
                             this.vs11=false
                             this.getTabledata()
                          }else{
                            this.$message.warning(res.message)
                          }
                })
            },

            onSubmit1() {
                addVolunteer({ voluntaryActivityId: this.voluntaryActivityId,
                     volunteerId: this.volunteerId1, 
                     userRealname: this.userRealname1 }).then((res)=>{
                        if(res.success){
                            this.$message.success("添加成功")
                            this.selectVolunteer()
                            this.volunteerId1=""
                            this.userRealname1=""
                        }else{
                            this.$message.warning(res.message)
                        }
                     })
                 
            },
            deleteVolun(data) {
                deleteVolunteer({ voluntaryActivityId: this.voluntaryActivityId, volunteerId: data.volunteerId }).then((res) => {
                    if (res.success) {
                        this.$message.success("删除成功")
                        this.selectVolunteer()
                    } else {
                        this.$message.warning("删除失败,请稍后再试");
                    }
                })
            },
            daochu() {
                window.location.href = "http://localhost:9090/voluntaryActivity/info/exportVoluntarActivity"
            },
            //页面显示
            searchonly() {
                this.getTabledata()
            },
            getTabledata() {
                this.load1 = true
                this.formData = {}
                selectVoluntaryActivityInfo({
                    voluntaryActivityName: this.voluntaryActivityName,
                    userRealname: this.userRealname,
                    status: this.status,
                    pageSize: this.page.limit,
                    current: this.page.current
                }).then((res) => {

                    if (res.success) {
                        console.log(res);
                        this.tableData = res.object
                        //this.form.voluntaryActivityTime = res.object[0].strVoluntaryActivityTime
                        this.load1 = false
                        this.dialogVisible=false
                    } else {
                        this.$message("系统忙稍后再试")
                        this.load1 = false
                    }
                })
            },


            //查看详情
            getDetaildata() {
                //this.formData = {}

                selectVoluntaryActivityDetailedInformation({
                    voluntaryActivityId: this.voluntaryActivityId,

                }).then((res) => {
                    if (res.success) {
                        console.log(res)

                        this.voluntaryActivityDetailedInformation = res.object[0].voluntaryActivityDetailedInformation

                        this.load = false
                    }
                })
            },
            selectVolunteer() {
                this.formData = {}
                this.tableData1=[]
                selectVolunteer({
                    voluntaryActivityId: this.voluntaryActivityId,

                }).then((res) => {
                    if (res.success) {
                    
                        this.tableData1 = res.object
                        this.load = false
                    }
                })
            },
            doWatch(data) {
                console.log(data);
                this.form.voluntaryActivityName=data.voluntaryActivityName
                this.form.voluntaryActivityTime=data.strVoluntaryActivityTime
                this.form.voluntaryActivityAddress=data.voluntaryActivityAddress
                this.form.status=data.status
                this.form.voluntaryActivityPeopleNumble=data.voluntaryActivityPeopleNumble
                this.form.voluntaryActivityDetailedInformation=data.voluntaryActivityDetailedInformation
                this.load = true
                this.dialogVisible = true
                this.voluntaryActivityId = ""
                this.voluntaryActivityId = data.voluntaryActivityId
                this.getDetaildata()
                this.selectVolunteer()

            },





            edit1() {
                this.vs11 = true
            },

            addVolunteer() {
                this.vs = true
            }
        },
        mounted() {
            this.getTabledata();
        },
    }
</script>
<style>

</style>