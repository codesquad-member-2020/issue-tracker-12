<template>
  <fragment>
    <div class="issue-edit">
      <div>
        <span>image</span>
      </div>
      <CreateIssueWrap>
        <input type="text" placeholder="Title" />
        <WriteContainer>
          <WriteBtn>Write</WriteBtn>
        </WriteContainer>
        <IssueTextArea name="" id="" cols="30" rows="10"></IssueTextArea>
        <button>test</button>
      </CreateIssueWrap>
    </div>
  </fragment>
</template>

<script>
import {
  CreateIssueWrap,
  WriteContainer,
  WriteBtn,
  IssueTextArea,
} from '@/style/styled';

export default {
  components: {
    CreateIssueWrap,
    WriteContainer,
    WriteBtn,
    IssueTextArea,
  },
};
</script>

<style lang="scss" scoped>
.issue-edit {
  display: flex;
}
</style>
