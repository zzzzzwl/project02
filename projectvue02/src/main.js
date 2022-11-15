import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import '@/assets/css/global.css'
//elementplus国际化
import 'dayjs/locale/zh-cn'

import locale from 'element-plus/lib/locale/lang/zh-cn'// 统一导入el-icon图标
import * as ElementPlusIconsVue from '@element-plus/icons'

const app = createApp(App)
//导入组件
for(let iconName in ElementPlusIconsVue){
    app.component(iconName,ElementPlusIconsVue[iconName])
}

app.use(store).use(router).use(ElementPlus,{ locale ,size:'small'}).mount('#app')
