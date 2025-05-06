import React from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import useMenuStore from '../store/MenuStore';
import { useEffect } from 'react';

const DetailMenu = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const { menu, getMenuId } = useMenuStore();

  useEffect(() => {
    const fetchMenu = async () => {
      await getMenuId(id);
    };
    fetchMenu();
  }, []);

  return (
    <>
      <div>{menu.id}</div>
      <button onClick={() => navigate('/')}>홈으로</button>
    </>
  );
};

export default DetailMenu;
