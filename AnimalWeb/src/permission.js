import router from './router'
import store from './store'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import { getToken } from '@/utils/cookie-token'
import getPageTitle from '@/utils/get-page-title'
import LOG from '@/utils/self-log'


NProgress.configure({
  showSpinner: false
}) // NProgress Configuration

router.beforeEach(async (to, from, next) => {

  // start progress bar
  NProgress.start()
  document.title = getPageTitle(to.meta.title)
  const routePathList = store.getters.routePathList;
  if (routePathList && routePathList.length > 0) {
  //   if (to.path == '/index' || to.path == '/404' || to.path == '/403' || to.path == '/login' || to.path == '/add-user' || to.path=='/user-manage/index') {
  //     next()
  //   } else if (routePathList.includes(`${to.path}`)) {
  //     //判断 有没有该路由
  //     const hasToken = getToken()
  //     if (hasToken) {
  //       try {
  //         const userInfo = store.getters.userInfo
  //         if (userInfo == null) {
  //           await store.dispatch('login/getInfo')
  //         }
          next()
        // } catch (errorObj) {
        //   LOG.warn(['errorObj -- ', errorObj])
        //   next(`/login`)
        //   NProgress.done()
        // }
      // } else {
      //   next(`/login`)
      //   NProgress.done()
      // }
  //   } else {
  //     //没有跳转至 404页面
  //     next("/404")
  //   }
  } else {
    //加载 routePathList ；重新进入
    await store.dispatch('router/setCreateStageRoutes');
    next({
      ...to,
      replace: true
    })
  }

})

router.afterEach((to, from) => {
  NProgress.done()
})
