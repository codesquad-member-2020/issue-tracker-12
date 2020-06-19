<template>
  <fragment>
    <IssueListWrap>
      <InnerListWrap>
        <IssueBox></IssueBox>
        <div>test2</div>
      </InnerListWrap>
    </IssueListWrap>
  </fragment>
</template>

<script>
import { IssueListWrap, InnerListWrap } from '@/style/styled';
import IssueBox from '@/components/issue/issue/IssueBox';
export default {
  components: {
    IssueListWrap,
    InnerListWrap,
    IssueBox,
  },
};
</script>

<style></style>
