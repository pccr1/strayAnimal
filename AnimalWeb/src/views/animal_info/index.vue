<template>
    <div class="list-view-layout" v-loading="load1">
        <json-filter>
            <el-form slot="form" :inline="true" @submit.native.prevent>
                <el-form-item label="动物名字：">
                    <el-input v-model="animalName" placeholder="请输入内容"></el-input>
                </el-form-item>
                <el-form-item label="物种：">
                    <el-input v-model="species" placeholder="请输入内容"></el-input>
                </el-form-item>
            </el-form>
            <div slot="buttons">
                <el-button plain @click="searchonly">查询</el-button>
                <el-button type="primary" @click="doAdd()">添加</el-button>
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
                <el-button type="text" @click="doDelete(1, iData.rowData.scope.row)">删除</el-button>
            </template>
        </json-table>
        <el-dialog title="详情页" :visible.sync="dialogVisible" width="40%" >
          
            
          <el-descriptions class="margin-top" title="" :column="1" :size="size" border v-loading="load" >
     
                  <el-descriptions-item>
                    <template slot="label">
                     
                     形象
                    </template>
                  <el-image :src="src"  style="width: 250px; height: 150px" > </el-image>
                    
                    
                  </el-descriptions-item>

          </el-descriptions>

          <p></p>

            <el-descriptions class="margin-top" title="详细信息" :column="3" :size="size" border v-loading="load" >
                
                <el-descriptions-item>
                  <template slot="label">
                  
                    ID
                  </template>
                  {{formData.animalId}}
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    
                    年龄
                  </template>
                  {{formData.animalAge}}
                  
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                
                    收容时间
                  </template>
                  {{formData.createTime}}
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                 
                  名字
                  </template>
                  {{formData.animalName}}
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
               
                    领养人ID
                  </template>
                  {{formData.userId}}
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                   
                     修改时间
                    </template>
                    {{formData.updateTime}}
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                
                      性别
                    </template>
                    {{formData.animalSex}}
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                   
                      领养状态
                    </template>
                    {{formData.animalAdoption}}
                   
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                     
                      领养时间
                    </template>
                    {{formData.animalAdoptionTime}}
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                      
                      品种
                    </template>
                    {{formData.varieties}}
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                     
                      是否绝育
                    </template>
                    {{formData.sterilization}}
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                     
                      绝育时间
                    </template>
                    {{formData.sterilizationTime}}
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                   
                      物种
                    </template>
                    {{formData.species}}
                   
                    
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                      
                      是否驱虫
                    </template>
                    {{formData.repellent}}
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                   
                      驱虫时间
                    </template>
                    {{formData.repellentTime}}
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                  
                      救助站
                    </template>
                    {{formData.rescueStationName}}
                    
                    
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                    
                      是否接种
                    </template>
                    {{formData.vaccination}}
                    
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                     
                     接种时间
                    </template>
                    {{formData.vaccinationTime}}
                    
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template slot="label">
                     
                     备注
                    </template>
                    {{formData.adoptionNotes}}
                    
                  </el-descriptions-item>
                  
              </el-descriptions>
              
                
                
              
              

               


              
              




            <span slot="footer" class="dialog-footer">
                <el-button @click="doEdit(iData.rowData.scope.row)" >修改</el-button>
                <el-button type="primary" @click="dialogVisible = false">取消</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    import JsonFilter from "@/components/JsonFilter";
    import JsonTable from "@/components/JsonTable";
    import {getAllAnimalInfo,addAnimalInfo,updateAnimalInfo,selectAnimals,deleteAnimal} from "@/api/animal.js";
    export default {
        components: { JsonFilter, JsonTable },
        data() {
            return {
                load:false,
                load1:false,
                
                animalId:"",
                src: 'https://img0.baidu.com/it/u=1597795879,1913003854&fm=253&fmt=auto&app=120&f=JPEG?w=1366&h=768',
                src1:'https://img0.baidu.com/it/u=2521003561,2654141216&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500',
                dialogVisible:false,
                animalName: "",
                species: "",
                tableHeads: [
                {
                    prop: "animalId",
                    label: "id"
                },
                {
                    prop: "animalName",
                    label: "动物名称"
                },
                {
                    prop: "species",
                    label: "物种"
                },
                {
                    prop: "rescueStationName",
                    label: "所属救助站"
                },
                {
                    slot: true,
                    prop: "operations",
                    label: "操作",
                }
                ],
                tableData: [],
                formData:{},
                page: {
                  limit: 20,
                  current: 1,
                  total: 20,
                },
                chooseEntity: null,

            }
        },
        methods: {
          searchonly(){
            this.getTabledata()
          },
          getTabledata(){
                this.load1=true
                this.formData={}
                getAllAnimalInfo({
                  animalName:this.animalName,
                  species:this.species,
                  pageSize:this.page.limit,
                  current:this.page.current
                }).then((res)=>{
                  console.log(res);
                  if(res.success){
                    this.tableData=res.object
                    this.load1=false
                  }else{
                    this.$message("系统忙稍后再试")
                    this.loading=false
                  }
                })
            },
            getDetaildata(){
                this.formData={}
            selectAnimals({
              animalId:this.animalId
            }).then((res)=>{
                if(res.success){
                    this.formData.animalId=res.object[0].animalId
                    this.formData.animalName=res.object[0].animalName
                    this.formData.animalSex=res.object[0].animalSex
                    this.formData.animalAge=res.object[0].animalAge
                    this.formData.rescueStationName=res.object[0].rescueStationName
                    this.formData.species=res.object[0].species
                    this.formData.varieties=res.object[0].varieties
                    
                    this.formData.sterilization=res.object[0].sterilization
                    this.formData.sterilizationTime = res.object[0].strSterilizationTime
                    this.formData.vaccination=res.object[0].vaccination
                    this.formData.vaccinationTime=res.object[0].strVaccinationTime
                    this.formData.repellent=res.object[0].repellent
                    this.formData.repellentTime=res.object[0].strRepellentTime
                    this.formData.animalAdoption=res.object[0].animalAdoption
                    this.formData.userId=res.object[0].userId
                    this.formData.animalAdoptionTime=res.object[0].strAnimalAdoptionTime
                    this.formData.adoptionNotes=res.object[0].adoptionNotes
                    this.formData.createTime=res.object[0].strCreateTime
                    this.formData.updateTime=res.object[0].strUpdateTime
                    this.load=false
                }
            })
            },

            doWatch(data){
                //this.dialogVisible = true
                
                this.load=true
                this.dialogVisible = true
                this.animalId=""
                this.animalId=data.animalId
                this.getDetaildata()
                
            },



            // 删除， type: 1 -单个删除；type: 2 -批量删除
        doDelete(type, e) {
            const tip = type == 1 ? '该条记录' : '选中记录'
            let ids = [e.id]
       
            this.$confirm(`确定删除${tip}？`, '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
                beforeClose: (action, instance, done) => {
                    if (action !== 'confirm') {
                        done()
                        return
                    }

                    deleteAnimal({animalId:e.animalId}).then((res)=>{
                     if(res.success){
                           this.$message('删除成功');
                           this.getTabledata();
                     }
                    })
                     done()
                }
            })
        },
        doEdit() {
            
        },
        doAdd(){
          
        }


        },
        mounted() {
            this.getTabledata();
        },


    }
</script>

<style>

</style>