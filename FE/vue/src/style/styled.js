import styled from 'vue-styled-components';

const btnType = { label: Boolean };

export const Wrapper = styled('div', btnType)`
  background-color: ${props => (props.label ? '#0366d6' : '#fff')};
  color: ${props => (props.label ? '#fff' : '#586069')};
  padding: 6px 14px;
  font-weight: 600;
  line-height: 20px;
  border: 1px solid;
  border-color: ${props => (props.label ? '#0366d6' : '#e1e4e8')};
  box-sizing: border-box;
  cursor: pointer;
`;

export const BtnWrapper = styled.div`
  display: flex;
`;

export const Title = styled.span`
  margin-left: 5px;
`;
