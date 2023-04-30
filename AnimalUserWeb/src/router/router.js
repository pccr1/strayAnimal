import Vue from 'vue'
import Router from 'vue-router'
import UserFooter from '@/views/UserFooter.vue'
import UserHome from '@/views/UserHome.vue'
import UserCommunity from '@/views/UserCommunity.vue'
import UserPost from '@/views/UserPost.vue'
import UserAnimal from '@/views/UserAnimal.vue'
import AlvelousPage from '@/views/AlvelousPage.vue'
import FooterOne from '@/components/animal/alvelous/page/footer/one/FooterOne.vue'
import FooterTwo from '@/components/animal/alvelous/page/footer/two/FooterTwo.vue'
import FooterThree from '@/components/animal/alvelous/page/footer/three/FooterThree.vue'
import UserMe from '@/views/UserMe.vue'
import MeData from '@/views/MeData.vue'
import UserLogin from '@/views/UserLogin.vue'
import UserRegister from '@/views/UserRegister.vue'
import UserAdd from '@/views/UserAdd.vue'

// push方法重写
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}
// replace方法重写
const originalReplace = Router.prototype.replace
originalReplace.replace = function replace(location) {
     return originalReplace.call(this, location).catch(err => err)
}

Vue.use(Router)

const routes=[
  {
    path:'/',
    redirect:{name:'home'}
  },
  {
    path:'/user',
    component:UserFooter,
    children:[
      {
        name:'home',
        path:'home',
        component:UserHome,
        meta:{
          keepAlive: true, // 添加该字段，表示该页面需要缓存
        }
      },
      {
        name:'community',
        path:'community',
        component:UserCommunity,
        meta:{
          keepAlive: true,
        }
      },
      {
        name:'animal',
        path:'animal',
        component:UserAnimal,
        meta:{
          keepAlive: true,
        }
      },
      {
        name:'me',
        path:'me',
        component:UserMe,
        meta:{
          // keepAlive: true,
        },
        children:[
          {
            name:'data',
            path:'data',
            component:MeData,
            meta:{
              // keepAlive: true,
            }
          }
        ]
      },
    ]
  },
  {
    name:'post',
    path:'/post',
    component:UserPost,
    meta:{
      // keepAlive: true,
    }
  },
  {
    name:'alvelous',
    path:'/alvelous',
    component:AlvelousPage,
    meta:{
      keepAlive: true,
    },
    children:[
      {
        name:'one',
        path:'one',
        component:FooterOne,
        meta:{
          keepAlive: true,
        }
      },
      {
        name:'two',
        path:'two',
        component:FooterTwo,
        meta:{
          keepAlive: true,
        }
      },
      {
        name:'three',
        path:'three',
        component:FooterThree,
        meta:{
          keepAlive: true,
        }
      },
    ]
  },
  {
    name:'login',
    path:'/login',
    component:UserLogin,
  },
  {
    name:'register',
    path:'/register',
    component:UserRegister,
  },
  {
    name:'add',
    path:'/add',
    component:UserAdd,
  },
  
]

////创建一个路由对象
const router = new Router({
  routes:routes,//初始化对象
})

//路由守卫
// router.beforeEach((to,from,next)=>{
  
//   if(localStorage.getItem('token')==null){
//     if(to.path=='/' || to.path=='/goodsinfo' || to.path=='/goodslist' || to.path=='/login' ){
//       next()
//     }else{
//       next('/login');
//     }
//   }else{
//     next();
//   }
// })

//暴露对象
export default router