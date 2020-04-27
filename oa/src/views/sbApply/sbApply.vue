<template>
    <div >
        <el-form class="apply-form" :model="submit" label-width="120px"  ref="submit">
            <el-row>
                <el-col :span="10"><el-form-item  label="申请人">
                    <el-input disabled v-model="submit.applyName"></el-input>
                </el-form-item></el-col>
<!--                <el-col :span="10">-->
<!--                    <el-form-item :span="12" label="部门">-->
<!--                        <el-input v-model="submit.name"></el-input>-->
<!--                    </el-form-item></el-col>-->
            </el-row>

            <el-row>
<!--                <el-col :span="10">-->
<!--                    <el-form-item label="申请标题">-->
<!--                        <el-input v-model="submit.name"></el-input>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
                <el-col :span="10">
                    <el-form-item label="申请类型">
<!--                        <el-input v-model="applyType"></el-input>-->
                        <el-select v-model="applyType" @change="slechange" placeholder="请选择">
                            <el-option
                                    v-for="item in applyTypes"
                                    :key="item.value"
                                    :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="20">
                    <el-form-item label="申请原因">
                        <el-input type="textarea" :autosize="{minRows:4,maxRows:6}" v-model="submit.applyReason"></el-input>
                    </el-form-item>
                </el-col>
             </el-row>
            <el-row>
                <el-col :span="20">
                    <el-form-item label=备注1>
                        <el-input type="textarea" :autosize="{minRows:4,maxRows:6}" v-model="submit.reMarksOne"></el-input>

                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="20">
                    <el-form-item label="备注2">
                        <el-input type="textarea" :autosize="{minRows:4,maxRows:6}" v-model="submit.reMarksTwo"></el-input>

                    </el-form-item>
                </el-col>
            </el-row>


<!--            <el-row>-->
<!--                <el-col :span="20">-->
<!--                    <el-form-item label="申请时间">-->
<!--                        <el-input type="textarea" :autosize="{minRows:4,maxRows:6}" v-model="submit.createTime"></el-input>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--            </el-row>-->
            <el-row >
                <el-col>
                    <el-form-item >
                        <el-button type="primary" @click="onSubmit">立即提交</el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>

    </div>
</template>

<script>
    import {equSave} from "../../api/api";
    import util from "../../common/js/util";

    export default {
        props:["sbInfo","applyDetails"],
        name: "sbApply",
        data(){
            return{
                submit:{
                    applyName:JSON.parse(sessionStorage.getItem("user")).userName
                },
                editFormRules:{
                    applyName:'',

                },
                userData:{},
                applyType:'',
                applyTypes:[{
                    value:'设备领用'
                },{
                    value:"设备维修"
                },{
                    value:"设备退还"
                }]
            }
        },
        activated(){

        },
        mounted(){
            let sbInfo = this._props.applyDetails;
            if (sbInfo){
                this.submit = Object.assign({},sbInfo)
                this.applyType = sbInfo.applyType;
            }

        },
        methods:{
            onSubmit(){
                this.$emit('changDialog');
                this.submit["createTime"] = util.formatDate.format(new Date());
                this.submit["state"] = "未审批"
                console.log(this.submit)
                equSave(this.submit).then(res=>{
                    alert("保存成功");
                })
            },
            slechange(val){
                this.submit.applyType = this.applyType
            }
        }
    }
</script>

<style scoped>
    .apply-form{
        text-align: left;
    }
</style>