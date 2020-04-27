<template>
    <div>
        <equ applyType="设备退还"></equ>
<!--        <sbList :equList="equList"></sbList>-->
<!--        <el-dialog title="领用详情" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">-->
<!--            <sbApply @changDialog="closeDialog"></sbApply>-->
<!--        </el-dialog>-->
    </div>

</template>

<script>
    import equ from "./equ";
    export default {
        name:'sblyList',
        components:{
            equ
        },
    }
    // import sbApply from "./sbApply";
    // import sbList from '../../components/sbComponent/sbList'
    // import {equList} from "../../api/api";
    //
    // export default {
    //     name: "sbthList",
    //     components:{
    //         sbList,sbApply
    //     },
    //     data(){
    //         return {
    //             equList:[]
    //         }
    //     },
    //     created() {
    //         equList({applyType:'设备退还'}).then(res=>{
    //             this.equList = res.data;
    //         })
    //     },
    //     methods:{
    //         closeDialog(){
    //             this.dialogVisible = false;
    //         },
    //         openDialog(){
    //             this.dialogVisible = true;
    //         },
    //     }
    // }
</script>

<style scoped>

</style>