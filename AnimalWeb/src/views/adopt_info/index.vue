<template>
  <div class="list-view-layout" v-loading="loading">
    <json-filter>
      <el-form slot="form" :inline="true" @submit.native.prevent>
        <el-form-item label="处理状态：">
          <el-select placeholder="请选择处理状态" v-model="animalAdoption">
            <el-option label="全部" value=""></el-option>
            <el-option label="未处理" value="未处理"></el-option>
            <el-option label="处理中" value="处理中"></el-option>
            <el-option label="已领养" value="已领养"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="buttons">
        <el-button plain @click="daochu" type="primary">全部导出</el-button>
        <el-button plain @click="searchonly">确认</el-button>
      </div>
    </json-filter>

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
    <el-dialog title="提示" :visible.sync="dialogVisible" width="50%">

      <el-descriptions class="margin-top" title="领养人信息" :column="2" border v-loading="loading1">

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            领养人姓名
          </template>
          {{tishixinxi.userRealname}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机号
          </template>
          {{tishixinxi.userPhone}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-location-outline"></i>
            联系地址
          </template>
          {{tishixinxi.userAddress}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            处理流程
          </template>
          <el-link type="primary" @click="watchLC">查看</el-link>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-message"></i>
            联系邮箱
          </template>
          {{tishixinxi.userEmail}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-alarm-clock
            "></i>
            申请时间
          </template>
          {{tishixinxi.createTime}}
        </el-descriptions-item>
      </el-descriptions>
      <el-descriptions class="margin-top" title="小动物信息" :column="3" border v-loading="loading1">
        <template slot="extra">
        </template>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-monitor"></i>
            小动物id
          </template>
          {{tishixinxi.animalId}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            小动物名称
          </template>
          {{tishixinxi.animalName}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-male"></i>
            性别
          </template>
          {{tishixinxi.animalSex}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-pie-chart"></i>
            年龄
          </template>
          {{tishixinxi.animalAge}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            是否绝育
          </template>
          {{tishixinxi.sterilization}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            所属物种
          </template>
          {{tishixinxi.species}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            所属救助站
          </template>
          {{tishixinxi.rescueStationName}}
        </el-descriptions-item>
        <template slot="extra">
          <el-button type="primary" size="small">操作</el-button>
        </template>
      </el-descriptions>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog title="申请流程" :visible.sync="Visible" width="20%">
      <el-timeline :reverse="reverse">
        <el-timeline-item
          v-for="(activity, index) in activities"
          :key="index"
          :timestamp="activity.timestamp">
          {{activity.content}}
        </el-timeline-item>
      </el-timeline>
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
  import { selectAdoptInfos, selectAdoptInfo } from "@/api/adopt.js";
  export default {
    components: { JsonFilter, JsonTable },
    data() {
      return {

        loading1: false,
        tishixinxi: {
          userRealname: "",
          userPhone: "",
          userAddress: "",
          userEmail: "",
          createTime: "",
          animalId: "",
          animalName: "",
          animalSex: "",
          animalAge: "",
          sterilization: "",
          species: "",
          rescueStationName: "",
        },
        loading: true,
        animalAdoption: "",
        Visible: false,
        dialogVisible: false,
        userRealName: "",
        param: {
          userRealname: "",
          userPhone: "",
          animalName: "",
          species: "",
        },
        reverse: true,
        activities: [{
          content: '活动按期开始',
          timestamp: '2018-04-15'
        }, {
          content: '通过审核',
          timestamp: '2018-04-13'
        }, {
          content: '创建成功',
          timestamp: '2018-04-11'
        }],
        tableHeads: [
          {
            prop: "userRealname",
            label: "领养人姓名",
          },
          {
            prop: "userPhone",
            label: "领养人联系电话",
          },
          {
            prop: "animalName",
            label: "动物名称",
          },
          {
            prop: "species",
            label: "动物物种",
          },
          {
            prop: "animalAdoption",
            label: "处理流程",
          },
          {
            slot: true,
            prop: "operations",
            label: "操作",
          },
        ],
        tableData: [],
        formLabelWidth: "120px",
        page: {
          limit: 10,
          current: 1,
          total: 0,
        },
        chooseEntity: null,
      };
    },
    methods: {
      daochu(){
        window.location.href="http://localhost:9090/animal/info/exportAnimalInfo"
      },
      Change(size){
        if (
       this.page.current > 1 &&
       (this.page.current - 1) * size > this.page.total
   ) {
       this.page.current = 1
   }
   this.page.limit = size
   this.getTableData()
      },
      searchonly() {
        this.getTableData()
      },
      getTableData() {
        this.loading = true
        selectAdoptInfos({ animalAdoption: this.animalAdoption
          ,pageSize:this.page.limit,
          pageCurrent:this.page.current
        }).then((res) => {
          if (res.success) {
            this.page.total = res.countSize
            this.tableData = res.object
            this.loading = false
          } else {
            this.$message("系统忙稍后再试")
            this.loading = false
          }
        })
      },

      watchLC(data) {
        this.Visible = true

      },
      updateSumbit() {

      },
      doSearch() {

      },
      currentPageChange(current) {
        this.page.current = current;
        this.getTableData()
      },
//       sizeChange(size) {
   
//    // 判断更换后当前页是否有数据
//    if (
//        this.page.current > 1 &&
//        (this.page.current - 1) * size > this.page.total
//    ) {
//        this.page.current = 1
//    }
//    this.page.limit = size
//    this.getTableData()
// },

      doWatch(data) {
        this.dialogVisible = true
        this.loading1 = true
        selectAdoptInfo({ userId: data.userId, animalId: data.animalId }).then((res) => {
          if (res.success) {
            this.page.total = res.countSize
            this.tishixinxi.userRealname = res.object[0].userRealname
            this.tishixinxi.userPhone = res.object[0].userPhone
            this.tishixinxi.userAddress = res.object[0].userAddress
            this.tishixinxi.userEmail = res.object[0].userEmail
            this.tishixinxi.createTime = res.object[0].strCreateTime
            this.tishixinxi.animalId = res.object[0].animalId
            this.tishixinxi.animalName = res.object[0].animalName
            this.tishixinxi.animalSex = res.object[0].animalSex
            this.tishixinxi.animalAge = res.object[0].animalAge
            this.tishixinxi.sterilization = res.object[0].sterilization
            this.tishixinxi.species = res.object[0].species
            this.tishixinxi.rescueStationName = res.object[0].rescueStationName
            this.loading1 = false
          } else {
            this.$message("请稍后再试")
          }
        })

      },
      doEdit(data) {

      },
    //   sizeChange(size) {

    //     // 判断更换后当前页是否有数据
    //     if (
    //       this.page.current > 1 &&
    //       (this.page.current - 1) * size > this.page.total
    //     ) {
    //       this.page.current = 1
    //     }
    //     this.page.limit = size

    //   },
    //   currentPageChange(current) {
    //   this.page.current = current;
    //   this.getTableData()
    // },
    },
    mounted() {
      this.getTableData()
    },
  };
</script>

<style>
</style>