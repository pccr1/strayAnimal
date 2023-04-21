import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/403',
    component: () => import('@/views/error-page/403'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/adopt_info',
  },

  {
    path: '/adopt_info1',
    component: Layout,
    redirect: '/adopt_info',
    meta: { icon: 'el-icon-s-order',title: '领养信息' },
    children: [
      {
        path: '/adopt_info',
        component: () => import('@/views/adopt_info'),
        name: 'adopt_info',
        meta: { title: '领养信息' },
      },
    ],
  },
  {
    path: '/volunteer_info1',
    component: Layout,
    redirect: '/volunteer_info',
    meta: {icon: 'el-icon-s-claim',title: '志愿者'},
    children: [
      {
        path: '/volunteer_info',
        component: () => import('@/views/volunteer_info'),
        name: 'volunteer_info',
        meta: { title: '志愿者管理' },
      },
      {
        path: '/volunteer_info2',
        component: () => import('@/views/volunteer_info/index1.vue'),
        name: 'volunteer_info2',
        meta: { title: '志愿活动管理' },
      },
      {
        path: '/volunteer_info3',
        component: () => import('@/views/volunteer_info/index2.vue'),
        name: 'volunteer_info3',
        meta: { title: '志愿者管理' },
      },
    ],
  },
  {
    path: '/animal_info1',
    component: Layout,
    redirect: '/animal_info1',
    meta: {icon: 'el-icon-s-custom' },
    children: [
      {
        path: '/animal_info',
        component: () => import('@/views/animal_info'),
        name: 'animal_info',
        meta: { title: '小动物们' },
      },
    ],
  },
  {
    path: '/sos.info1',
    component: Layout,
    redirect: '/sos.info1',
    meta: {icon: 'el-icon-s-comment' },
    children: [
      {
        path: '/sos.info',
        component: () => import('@/views/sos.info'),
        name: 'sos.info',
        meta: { title: '紧急救助' },
      },
    ],
  },
]


const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
