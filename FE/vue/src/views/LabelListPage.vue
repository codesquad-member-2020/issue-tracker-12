<template>
  <div>
    <HeaderComponent></HeaderComponent>
    <ContentComponent></ContentComponent>
  </div>
</template>

<script>
import HeaderComponent from '@/components/issue/label/HeaderComponent';
import ContentComponent from '@/components/issue/label/ContentComponent';

export default {
  components: {
    HeaderComponent,
    ContentComponent,
  },
};
</script>

<style></style>
