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
        path:'home',
        name:'Home',
        component:()=>import("@/views/Home")
      },
      {
        path:'music',
        name:'Music',
        component:()=>import("@/views/Music")
      }

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
