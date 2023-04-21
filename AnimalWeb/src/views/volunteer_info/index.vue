<template>
    <div class="list-view-layout" v-loading="load1">
        <json-table ref="myJsonTable" :table-heads="tableHeads" :table-data="tableData" :page="page"
            @current-change="currentPageChange" @size-change="Change">
            <template #usable="iData">
                <json-status :status="iData.rowData.scope.row.usable ? 'success' : 'error'"
                    :text="iData.rowData.scope.row.usable ? '启用' : '禁用'"></json-status>
            </template>
            <template #operations="iData">
                <el-button type="text" @click="doWatch(iData.rowData.scope.row)">查看详情</el-button>
            </template>
        </json-table>
        <el-dialog title="志愿者申请详情页" :visible.sync="dialogVisible" width="40%" >
            <el-descriptions class="margin-top" title="详细信息" :column="1" border v-loading="load" >
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-user"></i>
                        姓名
                    </template>
                    {{formData.userRealname}}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-male"></i>
                        性别
                    </template>
                    {{formData.userSex}}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-ship"></i>
                        年龄
                    </template>
                    {{formData.userAge}}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="
                    el-icon-c-scale-to-original"></i>
                        身份证号
                    </template>
                    {{formData.userIdNumber}}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-location-outline"></i>
                        联系地址
                    </template>
                    {{formData.userAddress}}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-mobile-phone"></i>
                        联系电话
                    </template>
                    {{formData.userPhone}}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-football"></i>
                        过去参加志愿活动情况
                    </template>
                    <el-input type="textarea" v-model="teaxx" :disabled="true"></el-input>
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="
                      el-icon-orange"></i>
                        备注
                    </template>
                    {{formData.adoptionNotes}}
                </el-descriptions-item>
            </el-descriptions>
            <span slot="footer" class="dialog-footer">
                <el-button @click="zanfan">暂返</el-button>
                <el-button type="primary" @click="dialogVisible = false">同意</el-button>
            </span>
        </el-dialog>

        <el-dialog title="暂返理由" :visible.sync="Visible" width="20%">
            <el-input type="textarea" :rows="3" placeholder="请输入理由" v-model="textarea">
            </el-input>
            <span slot="footer" class="dialog-footer">
                <el-button @click="Visible = false">取 消</el-button>
                <el-button type="primary" @click="Visible = false">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    import JsonFilter from "@/components/JsonFilter";
    import JsonTable from "@/components/JsonTable";
    import {getAllVolunteer} from "@/api/volunteer.js";
    export default {
        components: { JsonFilter, JsonTable },
        data() {
            return {
                load:false,
                load1:false,
                volunteerId:"",
                Visible: false,
                teaxx: "",
                dialogVisible: false,
                tableHeads: [{
                    prop: "volunteerId",
                    label: "申请ID",
                },
                {
                    prop: "userRealname",
                    label: "申请人姓名",
                },
                {
                    prop: "userPhone",
                    label: "申请人联系方式",
                },

                {
                    prop: "userAddress",
                    label: "申请人地址",
                }
                    ,
                {
                    prop: "adoptionNotes",
                    label: "申请人备注"
                },
                {
                    slot: true,
                    prop: "operations",
                    label: "操作",
                },
                ],
                tableData: [],
                formData:{
                },
          page: {
          limit: 20,
          current: 1,
          total: 0,
        },
            }
        },
        methods: {
            getDetaildata(){
                this.formData={}
            getAllVolunteer({
                volunteerId:this.volunteerId,
                pageSize:this.page.limit,
                current:this.page.current
            }).then((res)=>{
                if(res.success){
                  
                    this.formData.userRealname=res.object[0].userRealname
                    this.formData.userSex=res.object[0].userSex
                    this.formData.userAge=res.object[0].userAge
                    this.formData.userIdNumber=res.object[0].userIdNumber
                    this.formData.userPhone=res.object[0].userPhone
                    this.teaxx=res.object[0].volunteerOldActivities
                    this.formData.userAddress=res.object[0].userAddress
                    this.formData.adoptionNotes=res.object[0].adoptionNotes
                    this.load=false
                }
            })
            },
            getTabledata(){
                this.load1=true
                this.formData={}
            getAllVolunteer({
                volunteerId:this.volunteerId,
                pageSize:this.page.limit,
                current:this.page.current
            }).then((res)=>{
                if(res.success){
                    this.page.total = res.countSize
                    this.tableData=res.object
                    this.load1=false
                }
            })
            },
            doWatch(data) {
                this.load=true
                this.dialogVisible = true
                this.volunteerId=""
                this.volunteerId=data.volunteerId
                this.getDetaildata()

            },
            zanfan() {
                this.Visible = true
            },
    currentPageChange(current) {
        this.page.current = current;
        this.getTabledata()
      },
      Change(size){
        if (
       this.page.current > 1 &&
       (this.page.current - 1) * size > this.page.total
   ) {
       this.page.current = 1
   }
   this.getTabledata()
}
        },
        mounted() {
            this.getTabledata();
        },
    }
</script>

<style>

</style>