<template>
    <div class="list-view-layout">
        <json-filter>
            <el-form slot="form" :inline="true" @submit.native.prevent>
                <el-form-item label=" 救助状态：">
                    <el-select placeholder="请选择活动状态" v-model="status">
                        <el-option label="全部" value=""></el-option>
                        <el-option label="未处理 " value="未处理 "></el-option>
                        <el-option label="处理中" value="处理中"></el-option>
                        <el-option label="已完成" value="已完成"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="buttons">
                <el-button plain @click="searchonly">查询</el-button>
            </div>
        </json-filter>
        <json-table ref="myJsonTable" :table-heads="tableHeads" :table-data="tableData" :page="page"
            @current-change="currentPageChange" @size-change="sizeChange">
            <template #usable="iData">
                <json-status :status="iData.rowData.scope.row.usable ? 'success' : 'error'"
                    :text="iData.rowData.scope.row.usable ? '启用' : '禁用'"></json-status>
            </template>
            <template #operations="iData">
                <el-button type="text" @click="doWatch(iData.rowData.scope.row)">处理</el-button>
            </template>
        </json-table>
        <el-dialog title="处理页" :visible.sync="dialogVisible" width="25%">
            <el-col :span="11"><el-button @click="dialogVisible = false">志愿活动发布</el-button></el-col>
            <el-col :span="11"><el-button type="primary" @click="addVolunteer">设置为已处理</el-button></el-col>
            <br>
            <el-divider></el-divider>
            <el-input type="textarea" :rows="3" placeholder="此处输入暂返理由" v-model="textarea">
            </el-input>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="addVolunteer">暂返</el-button>
            </span>
        </el-dialog>
        <el-dialog title="添加参加活动的志愿者" :visible.sync="vs" width="20%">
            <span slot="footer" class="dialog-footer">
                <el-button @click="vs = false">取 消</el-button>
                <el-button type="primary" @click="vs = false">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
    import JsonFilter from "@/components/JsonFilter";
    import JsonTable from "@/components/JsonTable";
    export default {
        components: { JsonFilter, JsonTable },
        data() {
            return {

                vs11: false,
                volunteerId: "",
                userRealname: "",
                vs: false,
                dialogVisible: false,
                status: "",
                userRealname: "",
                tableData: [{
                    sosName: "小动物哈哈哈",
                    sosAddress: "临沂大学",
                    userRealname: "绝育鼠",
                    userPhone: "123456",
                    createTime: "2023-2-3 11:23:45",
                    sosDetailedInformation: "不知道填啥··"
                }],
                tableHeads: [{
                    prop: "sosName",
                    label: "救助名称"
                },
                {
                    prop: "sosAddress",
                    label: "救助活动地址"
                },
                {
                    prop: "userRealname",
                    label: "发布救助的用户姓名"
                }, {
                    prop: "userPhone",
                    label: "发布救助的用户联系方式"
                },
                {
                    prop: "createTime",
                    label: "发布时间"
                },
                {
                    prop: "sosDetailedInformation",
                    label: "活动详情"
                },
                {
                    slot: true,
                    prop: "operations",
                    label: "操作",
                }
                ]
            }
        },
        methods: {
            edit1() {
                this.vs11 = true
            },
            doWatch(data) {
                this.dialogVisible = true
            },
            addVolunteer() {
                this.vs = true
            }
        },
    }
</script>
<style>

</style>