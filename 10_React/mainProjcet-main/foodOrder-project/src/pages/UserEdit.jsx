import React, { useEffect } from 'react';
import styled from 'styled-components';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
import useUserStore from '../store/UserStore';
import Modal from '../components/Modal';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Wrap } from '../styled/common';
import TitleHeardr from '../components/TitleHeardr';

// yup 스키마
const schema = yup.object().shape({
  name: yup.string().required('이름을 입력하세요'),
  age: yup.number().typeError('숫자를 입력하세요').min(13, '13세 이하는 가입할 수 없습니다.'),
  email: yup.string().email('유효한 이메일 형식이 아닙니다.').required('이메일을 입력하세요'),
  pwd: yup
    .string()
    .matches(/^(?=.*[a-zA-Z]).{5,}$/, '비밀번호는 영문자를 포함해 5자 이상이어야 합니다.')
    .required('비밀번호를 입력해주세요'),
});

const UserEdit = () => {
  const navigate = useNavigate();
  const { currentUser, updateUser } = useUserStore();
  const [update, setUpdate] = useState(false);

  const {
    register,
    handleSubmit,
    setValue,
    reset,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(schema),
  });

  // 로그인 여부 확인
  useEffect(() => {
    if (!currentUser) {
      alert('로그인이 필요한 서비스입니다.');
      navigate('/');
    } else {
      // 기본값 세팅
      setValue('name', currentUser.name || '');
      setValue('age', currentUser.age || '');
      setValue('email', currentUser.email || '');
      setValue('pwd', currentUser.pwd || '');
    }
  }, [currentUser, setValue]);

  const onSubmit = async (data) => {
    try {
      console.log(data,",",currentUser)
      await updateUser({ ...currentUser, ...data });
      setUpdate(!update);
    } catch (error) {
      alert('정보 수정 중 오류가 발생했습니다.');
      console.error('❌ 업데이트 실패:', error);
    }
  };
const handleSetUpdae = (e) => {
e.preventDefault()
setUpdate(true)
}

const handeReset = () =>{
  reset(
    {
      name : currentUser.name,
      age : currentUser.age,
      email : currentUser.email,
      pwd : currentUser.pwd
    }
  )
  setUpdate(false)
}

  const [isModal, setIsModal] = useState(false);
  return (
    <>
      <Wrap>
        <TitleHeardr></TitleHeardr>
      {isModal && <Modal setIsModal={setIsModal}></Modal>
      }
      {console.log(isModal)}
        <FormWrapper onSubmit={handleSubmit(onSubmit)}>
          <h2>개인정보 수정</h2>
          이름 <input type="text" {...register('name')} readOnly={!update} />
          {errors.name && <ErrorText>{errors.name.message}</ErrorText>}
          나이 <input type="number" {...register('age')} readOnly={!update} />
          {errors.age && <ErrorText>{errors.age.message}</ErrorText>}
          이메일 <input type="email" {...register('email')} readOnly={!update} />
          {errors.email && <ErrorText>{errors.email.message}</ErrorText>}
          비밀번호 <input type="password" {...register('pwd')} readOnly />
          {errors.pwd && <ErrorText>{errors.pwd.message} </ErrorText>}
          <div>
            {update ? (
              <>
                <button type="submit">수정완료</button>
                <button type="button" onClick={handeReset}>
                  수정취소
                </button>
              </>
            ) : (
              <>
              {/* 클릭시에 onSubmit 이벤트가 실행되어서 다른 이벤트 확산 방지를 위해 아래와 같이 event 객체를 넘겨서 확산을 방지해야함 */}
                <button type="button" onClick={(e) => handleSetUpdae(e)}>
                  수정하기
                </button>
                <button type="button" onClick={() => setIsModal(true)}>
                  탈퇴하기
                </button>
              </>
            )}
          </div>
        </FormWrapper>

      </Wrap>
    </>
  );
};

export default UserEdit;

const FormWrapper = styled.form`
  display: flex;
  flex-direction: column;
  gap: 12px;
  padding: 18px;
  max-width: 600px;
  margin: 0 auto;

  input {
    padding: 8px;
    border: 1px solid #cccccc;
    border-radius: 4px;
  }

  input:read-only {
    background-color: #cccccc;
  }

  button {
    padding: 10px;
    background: #ff5100;
    color: white;
    border: none;
    border-radius: 6px;
    cursor: pointer;
  }
`;

const ErrorText = styled.p`
  font-size: 12px;
  color: red;
  margin: -8px 0 8px 0;
`;
