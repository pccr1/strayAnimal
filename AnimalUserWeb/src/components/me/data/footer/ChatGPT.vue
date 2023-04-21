<template>
    <div class="volunteer-info">
      <div class="top">
        <div class="avatar">
          <img :src="volunteer.avatar" alt="volunteer avatar">
        </div>
        <div class="info">
          <div class="name">{{ volunteer.name }}</div>
          <div class="id">{{ 'ID:' + volunteer.id }}</div>
          <div class="title">{{ volunteer.title }}</div>
          <div class="service">
            <span>服务时长：</span>
            <span>{{ volunteer.serviceTime }}</span>
          </div>
          <div class="service">
            <span>服务次数：</span>
            <span>{{ volunteer.serviceCount }}</span>
          </div>
        </div>
      </div>
      <div class="bottom">
        <div class="title">参加过的志愿活动</div>
        <el-table :data="volunteer.activities" style="width: 100%">
          <el-table-column prop="name" label="活动名称"></el-table-column>
          <el-table-column prop="time" label="参加时间"></el-table-column>
        </el-table>
      </div>
    </div>
</template>

<script>
export default {
name: 'VolunteerInfo',
props: {
    volunteer: {
    type: Object,
    required: true
    }
}
}
</script>

<style scoped>
  .volunteer-info {
    width: 350px;
    height: 550px;
    border: 1px solid #ccc;
    border-radius: 5px;
    overflow: hidden;
  }

  .top {
    display: flex;
    padding: 20px;
    background-color: #f5f5f5;
    align-items: center;
  }

  .avatar {
    width: 80px;
    height: 80px;
    border-radius: 50%;
    overflow: hidden;
    margin-right: 20px;
  }

  .avatar img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  .info {
    display: flex;
    flex-direction: column;
  }

  .name {
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 5px;
  }

  .id {
    font-size: 14px;
    color: #666;
    margin-bottom: 5px;
  }

  .title {
    font-size: 14px;
    margin-bottom: 5px;
  }

  .service {
    font-size: 14px;
    margin-bottom: 5px;
  }

  .bottom {
    padding: 20px;
  }

  .title {
    font-size: 16px;
    font-weight: bold;
    margin-bottom: 10px;
  }
</style>
