<template>
    <div >
        <el-form class="apply-form" :model="submit" label-width="120px" :rules="submit" ref="submit">
            <el-row>
                <el-col :span="10"><el-form-item  label="申请人">
                    <el-input v-model="submit.applyName"></el-input>
                </el-form-item></el-col>

            </el-row>

<!--            <el-row>-->
<!--                <el-col :span="10">-->
<!--                    <el-form-item  label="部门">-->
<!--                        <el-input v-model="submit.name"></el-input>-->
<!--                    </el-form-item></el-col>-->
<!--            </el-row>-->

            <el-row>
                <el-col :span="10">
                    <el-form-item label="客户名称">
                        <el-input v-model="submit.customer"></el-input>
                    </el-form-item>
                </el-col>

            </el-row>

            <el-row>
                <el-col :span="10">
                    <el-form-item label="目的地">
                        <el-input v-model="submit.dest"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="10">
                    <el-form-item label="出差时间"> <el-date-picker
                            width="100%"
                            v-model="dataTime"
                            type="daterange"
                            range-separator="至"
                            start-placeholder="开始日期"
                            end-placeholder="结束日期">
                    </el-date-picker></el-form-item>

                </el-col>
            </el-row>

            <el-row>

            </el-row>

            <el-row>
                <el-col :span="20">
                    <el-form-item label="出差事由">
                        <el-input type="textarea" :autosize="{minRows:4,maxRows:6}" v-model="submit.applyReason"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="20">
                    <el-form-item label="备注">
                        <el-input type="textarea" :autosize="{minRows:4,maxRows:6}" v-model="submit.reMark"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">信息提交</el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
    </div>
</template>

<script>
    import {ccSave} from "../../../api/api";
    import util from "../../../common/js/util";
    export default {
        props:["applyDetails"],
        name: "qjApply",
        data(){
            return {
                submit:{},
                dataTime:[]
            }
        },
        mounted(){
            let sbInfo = this._props.applyDetails;
            if (sbInfo){
                console.log(sbInfo);
                this.submit = Object.assign({},sbInfo)
                this.dataTime = [sbInfo.startTime,sbInfo.endTime];
                // this.applyType = sbInfo.applyType;
            }

        },
        methods:{
            onSubmit(){
                this.submit["startTime"] = this.dataTime[0];
                this.submit["endTime"] = this.dataTime[1];
                this.submit["state"] = "未审批"
                console.log(this.submit);
                ccSave(this.submit).then(res=>{
                    alert("保存成功");
                    this.$emit("getCcList");
                })
            }
        }
    }
</script>

<style scoped>

</style>