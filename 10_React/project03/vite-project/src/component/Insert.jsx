import React, { useState, useRef } from 'react';
import { useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from "@hookform/resolvers/yup";
const schema = yup.object({
  name: yup.string().required('이름을 입력해주세요'),
  email: yup.string().email().required('이메일을 입력해주세요'),
});

const Insert = () => {
  const {
    reaister,
    handlesubmit,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(schema),
  });
  const [input, setInput] = useState({
    name: '',
    birth: '',
    age: '',
    dep: '',
    bio: '',
  });

  const onSubmit = (data) => console.log(data)
  const handleChange = (ev) => {
    countRef.current++;
    console.log(countRef.current);
    setInput({ ...input, [ev.target.name]: ev.target.value });
  };
  const countRef = useRef(0);
  return (
    <form onSubmit={handlesubmit(onSubmit)}>
      <div>
        {console.log(input.name)}
        <input
          type="text"
          value={input.name}
          name="name"
          onChange={handleChange}
          {...reaister('name')}
        />
      </div>
      <div>
        <input
          type="Date"
          value={input.birth}
          name="birth"
          onChange={handleChange}
          {...reaister('birth')}
        />
      </div>
      <div>
        <input
          type="number"
          value={input.age}
          name="age"
          onChange={handleChange}
          {...reaister('age')}
        />
      </div>
      <div>
        <select
          name="dep"
          id="dep"
          value={input.dep}
          onChange={handleChange}
          {...reaister('dep')}
        >
          <option value="행정">행정</option>
          <option value="전산">전산</option>
          <option value="영업">영업</option>
          <option value="회계">회계</option>
        </select>
      </div>
      <div>
        <textarea
          type="textArea"
          value={input.bio}
          name="bio"
          onChange={handleChange}
          {...reaister('bio')}
        />
      </div>
      <button type="submit">제출</button>
    </form>
  );
};

export default Insert;
