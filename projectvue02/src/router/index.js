import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout'
const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect:"/home",
    children:[
      {
        path:'user',
        name:'User',
        component:()=>import("@/views/User")
      },
      {
        path:'music',
        name:'Music',
        component:()=>import("@/views/Music")
      },
      {
        path:'home',
        name:'Home',
        component:()=>import("@/views/Home")
      },
      {
        path:'album',
        name:'Album',
        component:()=>import("@/views/Album")
      },
      {
        path:'list',
        name:'List',
        component:()=>import("@/views/List")
      },

    ]
  },
  {
    path: '/Login',
    name: 'Login',
    component: ()=>import("@/views/Login")
  },
  {
    path: '/register',
    name: 'Register',
    component: ()=>import("@/views/Register")
  },


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
