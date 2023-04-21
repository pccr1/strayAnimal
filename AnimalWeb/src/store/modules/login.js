import {
  getUserInfo,
  login,
  logout
} from '@/api/login'
import {
  setToken,
  removeToken
} from '@/utils/cookie-token'
const state = {
  userInfo: null
}

const mutations = {
  SET_USER_INFO: (state, userInfo) => {
    state.userInfo = userInfo
  },
}

const actions = {
  login({
    commit
  }, userInfo) {
    return new Promise((resolve, reject) => {
      
      login({
        ...userInfo
      }).then(response => {
        if (response.success) {
         
          //setToken('LZQbubugao')
          
          resolve()
        } else {
          reject(data)
        }
      }).catch(error => {
        reject(error)
      })
    })
  },
  // 获取登录的人员信息
  // getInfo({
  //   commit,
  //   state
  // }) {
  //   return new Promise((resolve, reject) => {

  //     getUserInfo({}).then(response => {
  //       if (response.success) {
  //         const {
  //           root
  //         } = data
  //         commit('SET_USER_INFO', root[0]);
  //         setToken(root[0].userId)
  //         resolve(data)
  //       } else {
  //         reject(response)
  //       }
  //     }).catch(error => {
  //       const rejectObj = {
  //         redirect: false,
  //         errorMsg: error
  //       }
  //       reject(rejectObj)
  //     })
  //   })
  // },
  // user logout
  logout({
    commit,
    state
  }) {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {
        commit('SET_USER_INFO', null);
        removeToken()
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },
  resetToken({
    commit
  }) {
    return new Promise(resolve => {
      commit('SET_USER_INFO', null);
      removeToken();
      resolve()
    })
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
