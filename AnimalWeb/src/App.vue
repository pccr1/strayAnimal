<template>
    <div id="app">
        <router-view />
    </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
    name: 'App',
    data() {
        return {
            refreshLoginTimer: null
        }
    },
    computed: {
        ...mapGetters(['userInfo'])
    },
    mounted() {
        this.refreshLogin()
    },
    methods: {
        refreshLogin() {
            this.refreshLoginTimer = setInterval(() => {
                if (this.userInfo != null) {
                    try {
                        this.$store.dispatch('login/getInfo')
                    }
                    catch (err) {
                        this.$router.replace({ path: '/login' })
                    }
                }
            }, 10 * 60 * 1000)
        }
    },
    destroyed() {
        if (this.refreshLoginTimer != null) {
            clearInterval(this.refreshLoginTimer)
        }
    }
}
</script>
