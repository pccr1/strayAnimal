<template>
    <div :class="classObj" class="app-wrapper">
        <div class="sidebar-title">
            <div class="title">流浪动物救助系统</div>
        </div>
        <sidebar class="sidebar-container" />
        <div class="main-container">
            <div class="fixed-header">
                <navbar />
                <el-dropdown szie="medium">
                    <span class="dropdown-link">
                        <li class="el-icon-user-solid"></li> {{ userInfo.name }}<i
                            class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>
                            <span @click="logout">退出登录</span>
                        </el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
            <app-main />
            <copyright />
        </div>
    </div>
</template>

<script>
import { AppMain, Navbar, Sidebar, Copyright } from './components'
import ResizeMixin from '@/mixins/ResizeHandler'
import { mapState } from 'vuex'

export default {
    name: 'Layout',
    components: {
        AppMain,
        Navbar,
        Sidebar,
        Copyright
    },
    mixins: [ResizeMixin],
    computed: {
        ...mapState({
            sidebar: (state) => state.app.sidebar,
            // userInfo: (state) => state.login.userInfo,
            device: (state) => state.app.device
        }),
        classObj() {
            return {
                // hideSidebar: !this.sidebar.opened,
                // openSidebar: this.sidebar.opened,
                // withoutAnimation: this.sidebar.withoutAnimation
                hideSidebar: false,
                openSidebar: true,
                withoutAnimation: true
            }
        }
    },
    data() {
        return {
            roleDialog: false,
            userInfo:{name:'张天赐'}
        }
    },
    methods: {
        handleClickOutside() {
            this.$store.dispatch('app/closeSideBar', { withoutAnimation: false })
        },
        logout() {
            this.$store.dispatch('login/logout')
            this.$router.replace({ path: "/login" })
        }
    }
}
</script>

<style lang="scss" scoped>
@import "~@/styles/mixin.scss";
@import "~@/styles/variables.scss";

.app-wrapper {
    @include clearfix;
    position: relative;
    height: 100%;
    width: 100%;

    &.mobile.openSidebar {
        position: fixed;
        top: 0;
    }
}

.drawer-bg {
    background: #000;
    opacity: 0.3;
    width: 100%;
    top: 0;
    height: 100%;
    position: absolute;
    z-index: 999;
}

.fixed-header {
    position: fixed;
    top: 0;
    right: 20px;
    z-index: 9;
    width: calc(100% - #{$sideBarWidth} - 40px);
    transition: width 0.28s;
    border-bottom: 1px solid #eaeaea;
    display: flex;
    align-items: center;
    justify-content: space-between;
    background: #fff;
    padding-right: 20px;
}

.hideSidebar .fixed-header {
    width: calc(100% - 54px - 40px);
}

.mobile .fixed-header {
    width: 100%;
}

.dropdown-link {
    font-size: 15px;
    cursor: pointer;
}
</style>
