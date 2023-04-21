<template>
    <div style="float:left;height: 42px;margin-left: 10px;margin-top: 10px;">
        <!--头像-->
        <div style="float:left">
            <el-avatar :src="userAvatar"></el-avatar>
        </div>
        <!--姓名-->
        <div style="float:left;padding: 8px;">
            <el-link href="#" target="_blank" style="font-weight:bold;" :underline="false">{{ userNetWorkName }}</el-link>
        </div>
        <!--称号-->
        <div style="float:left;padding: 8px;">
            <el-link href="#" target="_blank" type="primary" style="font-size:13px" :underline="false">{{ userTitle }}</el-link>
        </div>
        <!--等级-->
        <div style="float:left;padding: 8px;">
            <el-tag effect="dark">Lv.{{ userLevel }}</el-tag>
        </div>
        
    </div>
</template>

<script>


export default {
    name: 'CardHead',
    props:{
        userAvatar:String,
        userNetWorkName:String,
        userTitle:String,
        userLevel:Number,
    },
    components: {

    }
}
</script>

<style scoped>
.el-tag {
    height: 20px;
    width: auto;
    line-height: 20px;
}
</style>

<!--
                       ::                              ::
                      :;J7, :,                        ::;J:
                      ,ivYi, ,                       ;LLLFS:
                      :iv7Yi                       :ri;j5PL
                     ,:ivYLvr                    ,ivrrirrY2X,
                     :;r@Wwzr:                 :ivu@kexianli.
                    :iL7::,:::iiirii:ii;::::,,irvF7rvvLujL7ur
                   ri::,:,::i:iiiiiii:i:irrv177JX7rYXqZEkvv17
                ;i:, , ::::iirrririi:i:::iiir2XXvii;L8OGJr71i
              :,, ,,:   ,::ir@mingyi.irii:i:::j1jri7ZBOS7ivv,
                 ,::,    ::rv77iiiriii:iii:i::,rvLq@huhao.Li
             ,,      ,, ,:ir7ir::,:::i;ir:::i:i::rSGGYri712:
           :::  ,v7r:: ::rrv77:, ,, ,:i7rrii:::::, ir7ri7Lri
          ,     OBBOi,iiir;r::        ,irriiii::,, ,iv7Luur:
        ,,     i78MBBi,:,:::,:,  :FSL: ,iriii:::i::,,:rLqXv::
        :      iuMMP: :,:::,:ii;GY7OBB0viiii:i:iii:i:::iJqL;::
       ,     ::::i   ,,,,, ::LuBBu BBBBBErii:i:i:i:i:i:i:r77ii
      ,       :       , ,,:::rruBZ1MBBqi, :,,,:::,::::::iiriri:
     ,               ,,,,::::i:  @arqiao.       ,:,, ,:::ii;i7:
    :,       rjujLYLi   ,,:::::,:::::::::,,   ,:i,:,,,,,::i:iii
    ::      BBBBBBBBB0,    ,,::: , ,:::::: ,      ,,,, ,,:::::::
    i,  ,  ,BMMBBBBBBi     ,,:,,     ,,, , ,   , , , :,::ii::i::
    :      iZMOMOMBBM2::::::::::,,,,     ,,,,,,:,,,::::i:irr:i:::,
    i   ,,:;u0MBMOG1L:::i::::::  ,,,::,   ,,, ::::::i:i:iirii:i:i:
    :    ,iuUuuXUkFu7i:iii:i:::, :,:,: ::::::::i:i:::::iirr7iiri::
    :     :rk@Yizero.i:::::, ,:ii:::::::i:::::i::,::::iirrriiiri::,
     :      sBMBBBBBBSr:,::rv2kuii:::iii::,:i:,, , ,,:,:i@petermu.,
          , :r50EZ8MBBBBGOBBBZP7::::i::,:::::,: :,:,::i;rrririiii::
              :jujYY7LS0ujJL7r::,::i::,::::::::::::::iirirrrrrrr:ii:
           ,:  :@kevensun.:,:,,,::::i:i:::::,,::::::iir;ii;v77;ii;i,
           ,,,     ,,:,::::::i:iiiii:i::::,, ::::iiiir@xingjief.r;:i,
        , , ,,,:,,::::::::iiiiiiiiii:,:,:::::::::iiir;ri7vL77rrirri::
         :,, , ::::::::i:::i:::i:i::,,,,,:,::i:i:::iir;@Secbone.ii:::
-->