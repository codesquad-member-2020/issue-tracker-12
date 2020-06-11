<template>
  <div class="input-container">
    <form v-on:submit.prevent class="form-container">
      <div class="">
        <svg
          class="octicon octicon-search subnav-search-icon"
          viewBox="0 0 16 16"
          version="1.1"
          width="16"
          height="16"
          aria-hidden="true"
        >
          <path
            fill-rule="evenodd"
            d="M11.5 7a4.499 4.499 0 11-8.998 0A4.499 4.499 0 0111.5 7zm-.82 4.74a6 6 0 111.06-1.06l3.04 3.04a.75.75 0 11-1.06 1.06l-3.04-3.04z"
          ></path>
        </svg>
        <input
          class="form-input"
          :placeholder="placeholder"
          type="text"
          v-model="searchTitle"
        />
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchTitle: '',
      placeholder: 'Search all labels',
    };
  },
};
</script>

<style lang="scss" scoped>
.form-container {
  position: relative;
}

.subnav-search-icon {
  position: absolute;
  top: 9px;
  left: 8px;
  display: block;
  color: #c6cbd1;
  text-align: center;
  pointer-events: none;
}

.form-input {
  padding: 6px 8px 6px 30px;
  font-size: 16px;
  line-height: 20px;
  color: #24292e;
  vertical-align: middle;
  background-color: #fff;
  background-repeat: no-repeat;
  background-position: right 8px center;
  border: 1px solid #d1d5da;
  border-radius: 3px;
  outline: none;
  box-shadow: inset 0 1px 2px rgba(27, 31, 35, 0.075);
}

.input-container {
  margin-left: 15px;
}
</style>
