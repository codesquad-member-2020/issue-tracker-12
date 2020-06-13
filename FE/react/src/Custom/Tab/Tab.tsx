/** @jsx jsx */
import { jsx, css } from '@emotion/core';
import Flex from '@Custom/Flex/Flex';
import { useState } from 'react';
import ReactMarkdown from 'react-markdown';

/**
 * 프로젝트 내에서 탭 컴포넌트를 활용해야할 때, Tab 컴포넌트를 사용하세요.
 *
 * - 내부적으로 Button 컴포넌트를 활용합니다. theme와 fontSize를 통해 Button의 테마와 글자 크기를 설정합니다.
 */

type TabProp = {
  tabs: string[];
  contentsWidth: string | number;
  contentsHeight: string | number;
};

const Tab = ({ tabs, contentsWidth, contentsHeight }: TabProp) => {
  const [selected, setSelected] = useState(Array.from(tabs, element => (element === tabs[0] ? true : false)));
  const [inputText, setInputText] = useState('');
  return (
    <Flex direction="column">
      <Flex align="left" gap="0.1rem">
        {tabs.map((tab, index) => (
          <div
            onClick={() => setSelected(onClickHandler(index)(selected))}
            css={[boxStyle, handleSelected(index)(selected)]}>
            {tab}
          </div>
        ))}
      </Flex>
      {selected[0] ? (
        <textarea
          css={[{ width: contentsWidth, height: contentsHeight }, textAreaStyle]}
          cols={10}
          rows={10}
          maxLength={500}
          value={inputText}
          onInput={(e: React.FormEvent<HTMLTextAreaElement>) => {
            setInputText(e.currentTarget.value);
          }}></textarea>
      ) : (
        <div css={[markdownBoxStyle, { width: contentsWidth, height: contentsHeight }]}>
          <ReactMarkdown source={inputText} className="markdown" />
        </div>
      )}
    </Flex>
  );
};

const textAreaStyle = css`
  box-sizing: border-box;
  padding: 0.5rem;
`;

const boxStyle = css`
  border: 1px solid #000000;
  padding: 0.5rem;
  cursor: pointer;
`;

const onClickHandler = (index: number) => (selected: boolean[]) => {
  const newSelected = Array.from(selected, element => false);
  newSelected[index] = !newSelected[index];
  return newSelected;
};

const handleSelected = (index: number) => (selected: boolean[]) => {
  if (selected[index]) {
    return css`
      background-color: #eeeeee;
    `;
  }
  return css``;
};

const markdownBoxStyle = css`
  border: 1px solid #000000;
  height: 100%;
  width: 100%;
  overflow-x: hidden;
  overflow-y: hidden;
  overflow: scroll;
  box-sizing: border-box;
  &::-webkit-scrollbar {
    display: none;
  }
  > .markdown {
    margin: 0px;
    padding-top: 1rem;
    padding-left: 1.5rem;
    font-size: 10px;
    overflow-x: hidden;
    overflow-y: hidden;
    overflow: hidden;
  }
`;

export default Tab;
