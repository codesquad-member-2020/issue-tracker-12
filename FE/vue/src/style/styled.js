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
  border-top-left-radius: ${props => (props.label ? '3px' : '0px')};
  border-bottom-left-radius: ${props => (props.label ? '3px' : '0px')};
  border-top-right-radius: ${props => (props.label ? '3px' : '0px')};
  border-bottom-right-radius: ${props => (props.label ? '3px' : '0px')};
`;

export const BtnWrapper = styled.div`
  display: flex;
`;

export const Title = styled.span`
  margin-left: 5px;
`;

export const CreateButton = styled.button`
  color: #fff;
  background-color: #28a745;
  background-image: linear-gradient(-180deg, #34d058, #28a745 90%);
  position: relative;
  display: inline-block;
  padding: 6px 12px;
  font-size: 14px;
  font-weight: 600;
  line-height: 20px;
  white-space: nowrap;
  vertical-align: middle;
  cursor: pointer;
  user-select: none;
  background-repeat: repeat-x;
  background-position: -1px -1px;
  background-size: 110% 110%;
  border: 1px solid rgba(27, 31, 35, 0.2);
  border-radius: 0.25em;
  appearance: none;
`;

export const Hedaer = styled.div`
  display: flex;
  justify-content: space-between;
  margin: 20px 0px;
`;

export const LabelContentWrap = styled.div`
  width: 100%;
  margin-top: 8px;
  margin-bottom: -8px;
  display: flex;
  position: relative;
  font-size: 14px;

  input {
    width: 100%;
    padding: 0px 8px;
    font-size: 14px;
    border: 1px solid #d1d5da;
    border-radius: 3px;
    outline: none;
    box-shadow: inset 0 1px 2px rgba(27, 31, 35, 0.075);
    background-color: #fafbfc;
    min-height: 32px;

    ::placeholder {
      color: #d1d5da;
    }
  }

  span {
    position: absolute;
    top: 19%;
    right: 26.5%;
    color: red;
    font-weight: 600;
  }
`;

export const LabelName = styled.div`
  width: 210px;
  margin: 15px 35px 15px 0px;
`;

export const LabelDesc = styled.div`
  width: 330px;
  margin: 15px 20px 15px 0px;
  padding-right: 16px;
`;

export const LabelColor = styled.div`
  width: 130px;
  margin: 15px 0;
  padding-right: 16px;
`;

const backgroundColor = { background: Object };
export const RandomColorButton = styled('button', backgroundColor)`
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: bold;
  width: 34px;
  height: 34px;
  margin-right: 5px;
  border-radius: 5px;
  border: 1px solid;
  border-color: ${props => `${props.background.backgroundColor}`};
  background-color: ${props => `${props.background.backgroundColor}`};
  color: ${props => `${props.background.textColor}`};
`;

export const LabelItemTitle = styled.div`
  display: block;
  margin-bottom: 8px;
  font-weight: 600;
`;

export const LabelSetButtons = styled.div`
  width: 200px;
  margin-left: 32px;
  margin: 15px 0;
  height: 32px;

  button {
    cursor: pointer;
    height: 35px;
    border-radius: 3px;
    padding: 7px 12px;
    font-size: 14px;
    font-weight: 550;
    border: 1px solid rgba(27, 31, 35, 0.2);
    outline: none;

    :hover {
      text-decoration: none;
      background-repeat: repeat-x;
      /* opacity: 0.8; */
    }
  }
`;

export const SetButtons = styled.div`
  display: flex;
  justify-content: flex-end;
  margin-top: 28px;
`;

export const CancelButton = styled.button`
  color: #000;
  background-color: #e6ebf1;
  background-image: linear-gradient(-180deg, #f0f3f6, #e6ebf1 90%);
  background-position: -0.5em;
  border-color: rgba(27, 31, 35, 0.35);
  margin-right: 5px;

  position: relative;
  display: inline-block;
  padding: 6px 12px;
  font-size: 14px;
  /* font-weight: 600; */
  /* line-height: 20px; */
  white-space: nowrap;
  vertical-align: middle;
  /* cursor: pointer; */
`;

export const SaveButton = styled.button`
  color: #fff;
  background-color: #28a745;
  background-image: linear-gradient(-180deg, #34d058, #28a745 90%);
  opacity: 0.5;
`;

export const ChangeSaveLabel = styled.button`
  color: #fff;
  background-color: #28a745;
  background-image: linear-gradient(-180deg, #34d058, #28a745 90%);
  opacity: 1;
`;

export const ColorSelectTab = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
  input {
    width: 75%;
  }
`;

export const CreateLabelWrap = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
`;

export const CreateLabelInner = styled.div`
  width: 100%;
  border: 1px solid #e1e4e8;
  background-color: #f6f8fa;
  border-radius: 4px;
  margin-bottom: 16px;
  padding: 16px;
  font-size: 12px;
  .edit_buttons {
    margin-top: 29px;
  }
`;

const labelStyle = { label: Object };

export const LabelPreview = styled('div', labelStyle)`
  display: inline-block;
  box-sizing: border-box;
  font-weight: bold;
  font-size: 14px;
  padding: 4px 8px;
  border-radius: 3px;
  color: ${props => (props.label ? `${props.label.textColor}` : 'none')};
  background-color: ${props =>
    props.label ? `${props.label.backgroundColor}` : 'none'};
`;

const changeLabelStyle = { randomStyle: Object };

export const changeLabelPreview = styled('div', changeLabelStyle)`
  display: inline-block;
  box-sizing: border-box;
  font-weight: bold;
  font-size: 14px;
  padding: 4px 8px;
  border-radius: 3px;
  color: ${props =>
    props.randomStyle ? `${props.randomStyle.textColor}` : 'none'};
  background-color: ${props =>
    props.randomStyle ? `${props.randomStyle.backgroundColor}` : 'none'};
`;

const previewStyle = { RandomHexColor: Object };
export const previewCreateLabel = styled('div', previewStyle)`
  display: inline-block;
  box-sizing: border-box;
  font-weight: bold;
  font-size: 14px;
  padding: 4px 8px;
  border-radius: 3px;
  color: ${props =>
    props.RandomHexColor ? `${props.RandomHexColor.textColor}` : 'none'};
  background-color: ${props =>
    props.RandomHexColor ? `${props.RandomHexColor.backgroundColor}` : 'none'};
`;

export const LabelListWrap = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  background-color: #fff;
  font-size: 12px;
  color: #586069;
`;

export const InnerListWrap = styled.div`
  box-sizing: border-box;
  display: flex;
  align-items: center;
  flex-direction: column;
  background-color: #fff;
  width: 100%;
`;

export const ListTopMenu = styled.div`
  display: flex;
  justify-content: space-between;
  width: 96.5%;
  background-color: #f6f8fa;
  margin: -1px -1px 0;
  padding: 16px;
  border: 1px solid #d1d5da;
  border-top-left-radius: 3px;
  border-top-right-radius: 3px;
  font-size: 14px;
  font-weight: 600;
  color: #000;
`;

export const LabelItem = styled.div`
  width: 100%;
  flex-direction: column;
`;

export const LabelTab = styled.div`
  width: 25%;
`;

export const EditLabelTab = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
`;

export const Info = styled.div`
  width: 99.9%;
  display: flex;
  align-items: center;
  border: 1px solid #d1d5da;
  border-top: none;
  box-sizing: border-box;
  padding: 16px;
`;

export const EditInfo = styled.div`
  width: 99.9%;
  display: flex;
  align-items: center;
  border: 1px solid #d1d5da;
  border-top: none;
  box-sizing: border-box;
  padding: 16px;
  flex-direction: column;
`;

export const DescriptionTab = styled.div`
  width: 33.3333%;
`;

export const MutedLinkTab = styled.div`
  width: 25%;
`;

export const ButtonTab = styled.div`
  display: flex;
  justify-content: flex-end;
  width: 16.66667%;
`;

export const Button = styled.button`
  display: inline-block;
  border: none;
  background: none;
  outline: none;
  font-size: 12px;
  margin-left: 16px !important;
  color: #586069;
  cursor: pointer;
  :hover {
    color: #0366d6;
    text-decoration: underline;
  }
`;

export const LabelNameError = styled.div`
  color: #86181d;
  background-color: #ffdce0;
  border-color: #cea0a5;
  position: absolute;
  z-index: 10;
  display: block;
  max-width: 450px;
  padding: 5px 8px;
  margin: 4px 0 0;
  font-size: 13px;
  font-weight: 400;
  border-style: solid;
  border-width: 1px;
  border-radius: 3px;
  &:before {
    margin-left: -1px;
    border-width: 6px;
    border-bottom-color: #cea0a5;
    position: absolute;
    bottom: 100%;
    left: 10px;
    z-index: 15;
    width: 0;
    height: 0;
    pointer-events: none;
    content: ' ';
    border: solid transparent;
  }
  &:after {
    border-bottom-color: #ffdce0;
    border-width: 5px;
    position: absolute;
    bottom: 100%;
    left: 10px;
    z-index: 15;
    width: 0;
    height: 0;
    pointer-events: none;
    content: ' ';
    border: solid transparent;
  }
`;
