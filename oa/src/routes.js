import Login from './views/Login.vue'
import NotFound from './views/404.vue'
import Home from './views/Home.vue'
import Main from './views/Main.vue'
import Table from './views/nav1/Table.vue'
import Form from './views/nav1/Form.vue'
import rwApply from "./views/rw/rwApply";
import rwList from "./views/rw/rwList";
import meeting from './views/meeting.vue'
import file from './views/file.vue'
import notice from './views/notice.vue'
import jobRecoder from './views/jobRecoder.vue'
import userInfo from "./views/userManage/userInfo";
import echarts from './views/charts/echarts.vue'
import fa from "element-ui/src/locale/lang/fa";

let routes = [
    {
        path: '/login',
        component: Login,
        name: '',
        hidden: true
    },
    {
        path: '/404',
        component: NotFound,
        name: '',
        hidden: true
    },
    {
        path: '/',
        component: Home,
        iconCls:'info-circle',
        leaf: true,//只有一个节点
        children: [
            { path: '/notice', component: notice, name: '通知公告' }
        ]
    },
    {
        path: '/',
        component: Home,
        iconCls: 'files',
        leaf: true,//只有一个节点
        children: [
            { path: '/file', component: file, name: '文件管理' }
        ]
    },
    {
        path: '/',
        component: Home,
        name: '公司设备',
        iconCls: 'display',//图标样式class
        children: [
            { path: '/main', component: Main, name: '主页', hidden: true },
            { path: '/sbApply', component: ()=>import('./views/sbApply/sbApply'), name: '设备申请' },
            { path: '/sblyList', component: ()=>import('./views/sbApply/sblyList'), name: '领用列表' },
            { path: '/sbwxList', component: ()=>import('./views/sbApply/sbwxList'), name: '维修列表' },
            { path: '/sbthList', component: ()=>import('./views/sbApply/sbthList'), name: '退还列表' },
        ]
    },
    {
        path: '/',
        component: Home,
        name:'业务申请',
        iconCls: 'briefcase',//图标样式class
        children: [
            { path: '/main', component: Main, name: '主页', hidden: true },
            { path: '/ccApply', component: ()=>import('./views/ywApply/ccApply/ccApply'), name: '出差申请' },
            { path: '/gcApply', component: ()=>import('./views/ywApply/gcApply/gcApply'), name: '公出申请' },
            { path: '/jbApply', component: ()=>import('./views/ywApply/jbApply/jbApply'), name: '加班申请' },
            { path: '/qjApply', component: ()=>import('./views/ywApply/qjApply/qjApply'), name: '请假申请' },
        ]
    },
    {
        path: '/',
        component: Home,
        name:'业务列表',
        iconCls: 'briefcase',//图标样式class
        children: [
            { path: '/main', component: Main, name: '主页', hidden: true },
            { path: '/ccList', component: ()=>import('./views/ywApply/ccApply/ccList'), name: '出差列表' },
            { path: '/gcList', component: ()=>import('./views/ywApply/gcApply/gcList'), name: '公出列表' },
            { path: '/jbList', component: ()=>import('./views/ywApply/jbApply/jbList'), name: '加班列表' },
            { path: '/qjList', component: ()=>import('./views/ywApply/qjApply/qjList'), name: '请假列表' },
        ]
    },
    {
        path: '/',
        component: Home,
        iconCls: 'list-task',
        name:'任务分派',
        children: [
            { path: '/rwApply', component: ()=>import('./views/rw/rwApply'), name: '增加任务' },
            { path: '/rwList', component: ()=>import('./views/rw/rwList'), name: '任务列表' }
        ]
    },
    {
        path: '/',
        component: Home,
        name:'工作日志',
        leaf: true,
        iconCls: 'layout-text-sidebar-reverse',//图标样式class
        children: [
            { path: '/jobRecord', component: jobRecoder, name: '日志系统' },
        ]
    },
    {
        path: '/',
        component: Home,
        leaf: true,
        iconCls: 'people',//图标样式class
        children: [
            { path: '/meeting', component: meeting, name: '会议管理' },
        ]
    },
    {
        path: '/',
        component: Home,
        iconCls: 'person',//图标样式class
        leaf: true,
        children: [
            { path: '/userInfo', component: userInfo, name: '用户管理'},
        ],
    },
    {
        path: '*',
        hidden: true,
        redirect: { path: '/404' }
    }
];

export default routes;