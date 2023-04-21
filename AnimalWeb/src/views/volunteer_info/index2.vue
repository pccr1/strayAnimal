<template>
    <div class="list-view-layout">
        <json-filter>
            <el-form slot="form" :inline="true" @submit.native.prevent>
                <el-form-item label="姓名：">
                    <el-input v-model="userRealname" placeholder="请输入内容"></el-input>
                </el-form-item>
                <el-form-item label="联系方式：">
                    <el-input v-model="userPhone" placeholder="请输入内容"></el-input>
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
                <el-button type="text" @click="doWatch(iData.rowData.scope.row)">详情</el-button>
                <el-button type="text" @click="doWatch(iData.rowData.scope.row)">删除</el-button>
            </template>
        </json-table>
        <el-dialog title="详情" :visible.sync="dialogVisible" width="40%">
            <el-descriptions class="margin-top" title="用户基本信息" :column="3" :size="size" border>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-user"></i>
                        志愿者ID
                    </template>
                    1
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-mobile-phone"></i>
                        用户ID
                    </template>
                    1
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-location-outline"></i>
                        姓名
                    </template>
                    小白
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-tickets"></i>
                        网名
                    </template>
                        大白
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-office-building"></i>
                        身份证号
                    </template>
                    17756465123123
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-location-outline"></i>
                        性别
                    </template>
                    男
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-location-outline"></i>
                        联系方式
                    </template>
                    110119120911922
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-location-outline"></i>
                        出生日期
                    </template>
                    2022-11-23
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-location-outline"></i>
                        称号
                    </template>
                    志愿标兵
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-location-outline"></i>
                        志愿活动次数
                    </template>
                    35
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-location-outline"></i>
                        住址
                    </template>
                    臭水沟
                </el-descriptions-item>
            </el-descriptions>
            <el-descriptions class="margin-top" title="志愿活动经历" :column="1" :size="size" border>
      
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-user"></i>
                       过去参加志愿活动情况
                    </template>
                    卡拉是快乐的吗，吗次想买车，。怎么。，买自行车，。 阿什利；看到了；快乐；去看望mz.cm真聪明了；五块钱额
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-mobile-phone"></i>
                        目前参加志愿活动
                    </template>         
                    的；路撒开车子下面，。怎么写，怕【21 买这么少吗，。按了13吗，。奥术弹幕阿片类；理1亮；了12；‘ ；’阿萨德        
                </el-descriptions-item>
            </el-descriptions>
            <el-descriptions class="margin-top" title="时间" :column="2" :size="size" border>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-mobile-phone"></i>
                        创建时间
                    </template>      
                    2022-1-23   
                 </el-descriptions-item>
                 <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-mobile-phone"></i>
                        修改时间
                    </template>
                    2021-1-23         
                </el-descriptions-item>
            </el-descriptions>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">确定</el-button>
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
                userPhone: "",
                form: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                },
                volunteerId: "",
                userRealname: "",
                dialogVisible: false,
                userRealname: "",
                tableData: [{
                    userRealname: "尤呈祥",
                    userPhone: "15806913747",
                    volunteerActivitiesNumber: "15",
                    volunteerTitle: "志愿标兵",
                    userAddress: "山东省临沂市兰山区"
                }],
                tableHeads: [{
                    prop: "userRealname",
                    label: "姓名"
                },
                {
                    prop: "userPhone",
                    label: "联系方式"
                },
                {
                    prop: "volunteerActivitiesNumber",
                    label: "志愿活动次数"
                }, {
                    prop: "volunteerTitle",
                    label: "称号"
                },
                {
                    prop: "userAddress",
                    label: "住址"
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
       
            doWatch(data) {
                this.dialogVisible = true
            },

        },
    }
</script>
<style>

</style>