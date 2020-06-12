/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Button from '@Custom/Button/Button';
import Flex from '@Custom/Flex/Flex';
import Icon, { IconType } from '@Icon/Icon';

type LabelButtonProp = {
  /** 활용하고 싶은 아이콘을 정할 수 있습니다 */
  iconType: IconType;
  /** LabelButton이 나타내고 싶은 Label을 적을 수 있습니다 */
  label: string;
  /** LabelButton이 차지하는 가로 길이를 정할 수 있습니다 */
  width?: string | number;
};

/**
 * 프로젝트 내에서 레이블 관련 버튼 컴포넌트를 활용해야할 때, LabelButton 컴포넌트를 사용하세요.
 *
 */

const LabelButton = ({ iconType, label, width }: LabelButtonProp) => {
  return (
    <div css={[style, { width }]}>
      <Button theme="nocolor">
        <Flex alignItemCenter={true}>
          <Icon icon={iconType} size="15px"></Icon>
          <p>{label}</p>
          <div css={circleStyle}>8</div>
        </Flex>
      </Button>
    </div>
  );
};

const style = css`
  border: 1px solid #000000;
  box-sizing: border-box;
  height: 31px;
`;

const circleStyle = css`
  background-color: #e5e7e9;
  border-radius: 50%;
  width: 30%;
  height: 30%;
`;

export default LabelButton;
