<template>
  <fragment>
    <ContentWrapper>
      <FormContainer>
        <ItemContainer>
          <LabelTitle>Title</LabelTitle>
          <input
            type="text"
            placeholder="Title"
            :value="milestoneTitle"
            @input="inputHandler"
          />
        </ItemContainer>
        <ItemContainer>
          <LabelTitle>Due date (optional)</LabelTitle>
          <input
            type="date"
            pattern="\d\d\d\d-\d\d-\d\d"
            placeholder="연도. 월. 일."
            @change="dateHandler"
            v-model="milestoneDate"
          />
        </ItemContainer>
        <ItemContainer>
          <LabelTitle>Description</LabelTitle>
          <textarea
            :value="milestoneDescription"
            @input="descriptionHandler"
          ></textarea>
        </ItemContainer>
      </FormContainer>
    </ContentWrapper>
    <BtnContainer v-if="!isParams">
      <CreateButton
        :btnTitle="'Create milestone'"
        @click.native="createMilestone"
      ></CreateButton>
    </BtnContainer>
    <BtnContainer v-else>
      <CancelButton :btnTitle="'Cancel'"></CancelButton>
      <CancelButton
        v-if="isOpenItem"
        :btnTitle="'Close milestone'"
      ></CancelButton>
      <CancelButton v-else :btnTitle="'Reopen milestone'"></CancelButton>
      <CreateButton
        :btnTitle="'Save Changes'"
        @click.native="changeMilestone"
      ></CreateButton>
    </BtnContainer>
  </fragment>
</template>

<script>
import {
  FormContainer,
  LabelTitle,
  ItemContainer,
  ContentWrapper,
  BtnContainer,
} from '@/style/styled';
import CreateButton from '@/components/common/CreateButton';
import CancelButton from '@/components/common/CancelButton';

export default {
  data() {
    return {
      milestoneTitle: '',
      milestoneDate: '',
      milestoneDescription: '',
      isParams: false,
    };
  },
  computed: {
    isOpenItem() {
      const bOpen = this.$store.state.milestonesList.filter(
        item => item.id == this.$route.params.id,
      );
      return bOpen[0].isOpen;
    },
  },
  created() {
    if (this.$route.params.hasOwnProperty('id')) {
      const target = this.$store.state.milestonesList.filter(
        milestone => milestone.id == this.$route.params.id,
        (this.isParams = !this.isParams),
      );
      this.milestoneTitle = target[0].title;
      this.milestoneDate = target[0].dueDate;
      this.milestoneDescription = target[0].description;
    }
  },
  components: {
    FormContainer,
    LabelTitle,
    ItemContainer,
    ContentWrapper,
    CreateButton,
    BtnContainer,
    CancelButton,
  },
  methods: {
    createMilestone() {
      if (this.milestoneTitle === '')
        return alert('Title을 필수로 입력해주세요');
      const obj = {
        id: this.$store.state.milestonesList.length + 1,
        title: this.milestoneTitle,
        dueDate: this.milestoneDate,
        description: this.milestoneDescription,
        isOpen: true,
        linkIssues: [],
      };
      this.$store.commit('createMilestone', obj);
      this.$router.push('/milestoneList');
    },
    inputHandler({ target: { value } }) {
      this.milestoneTitle = value;
    },
    dateHandler({ target: { value } }) {
      console.log(value);
      this.milestoneDate = value;
    },
    descriptionHandler({ target: { value } }) {
      this.milestoneDescription = value;
    },
    changeMilestone() {
      console.log('change');
    },
  },
};
</script>

<style lang="scss" scoped></style>
