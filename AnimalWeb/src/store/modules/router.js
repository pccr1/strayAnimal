import {
  constantRoutes
} from '@/router'

export function handleTreeToList(routes) {
  let list = []
  routes.forEach(route => {
    const tmp = {
      ...route
    };
    list.push(tmp.path);
    if (tmp.children && tmp.children.length > 0) {
      list = [...list,...handleTreeToList(tmp.children)]
    }
  })
  return list
}

const state = {
  //用于生成树
  routeTree: [],
  //用于 判断有没有该路由，跳转至404
  routePathList: []
}

const mutations = {
  SET_ROUTE_TREE: (state, routeTree) => {
    state.routeTree = routeTree
  },
  SET_ROUTE_PATH_LIST: (state, routePathList) => {
    state.routePathList = routePathList
  },
}

const actions = {

  setCreateStageRoutes({
    commit
  }) {
    return new Promise((resolve, reject) => {
      commit('SET_ROUTE_TREE', constantRoutes);
      let routePathList = handleTreeToList(constantRoutes);
      console.log("routePathList --> ", routePathList);
      commit('SET_ROUTE_PATH_LIST', routePathList);
      resolve(constantRoutes)
    })
  },

  removeRoutes({
    commit
  }) {
    return new Promise(resolve => {
      commit('SET_ROUTES', []);
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
