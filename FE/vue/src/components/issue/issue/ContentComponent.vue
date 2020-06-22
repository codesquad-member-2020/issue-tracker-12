<template>
  <fragment>
    <IssueListWrap>
      <InnerListWrap>
        <IssueBox></IssueBox>
        <IssueList />
      </InnerListWrap>
    </IssueListWrap>
  </fragment>
</template>

<script>
import { IssueListWrap, InnerListWrap } from '@/style/styled';
import IssueBox from '@/components/issue/issue/IssueBox';
import IssueList from '@/components/issue/issue/IssueList';

export default {
  components: {
    IssueListWrap,
    InnerListWrap,
    IssueBox,
    IssueList,
  },
};
</script>

<style></style>
