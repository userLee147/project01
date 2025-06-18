import React, { useState } from 'react';
import useUserStore from '../store/UserStore';
import { CommonBtn, Wrap, HeaderWrap } from '../styled/common';

import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import Header from '../components/Header';
import TitleHeardr from '../components/TitleHeardr';

const Login = () => {
  const [id, setId] = useState('');
  const [pwd, setPwd] = useState('');
  const { currentUser, login, logout } = useUserStore();
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    if (id.trim() === '' || pwd.trim() === '') {
      return;
    }

    try {
      await login(id, pwd);
      navigate('/');
    } catch (err) {
      alert(err.message);
    }
  };

  const handleLogout = async (e) => {
    e.preventDefault();
    await logout(currentUser);
    navigate('/');
  };

  // useEffect(() => {
  //   console.log("유저 상태 변화:", currentUser);
  // }, [currentUser]);

  return (
    <Wrap>
      <TitleHeardr></TitleHeardr>
      <FormWrapper onSubmit={handleLogin}>
        <h1>로그인</h1>
        <div>
          <input type="text" id="id" value={id} onChange={(e) => setId(e.target.value)} placeholder="아이디" />

          <input type="password" id="pwd" value={pwd} onChange={(e) => setPwd(e.target.value)} placeholder="비밀번호" />
        </div>

        <button type="submit">로그인</button>
      </FormWrapper>

      <BtnBox>
        <Btn to="/user">회원가입</Btn>
        <Btn>비밀번호 찾기</Btn>
      </BtnBox>
    </Wrap>
  );
};

export default Login;

const FormWrapper = styled.form`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 20px;
  padding: 10px;
  max-width: 600px;
  margin: 0 auto;

  input {
    width: 400px;
    padding: 8px;
    margin: 5px;
    border: 1px solid #cccccc;
    border-radius: 4px;
  }

  button {
    width: 400px;
    padding: 10px;
    background: #ff5100;
    color: white;
    border: none;
    border-radius: 6px;
    cursor: pointer;
  }
`;

const BtnBox = styled.div`
  display: flex;
  width: 400px;
  margin: 0px auto;
  justify-content: space-between;
  align-items: center;
  gap: 5px;
`;
const Btn = styled(CommonBtn)`
  width: 50%;
  font-size: 15px;
`;
