import { create } from 'zustand';
import axios from 'axios';

const useMenuStore =create((set, get) => ({

    menuList : [],
    menu : {},
    getMenuList: async () => {
        try {
          const response = await axios.get('http://localhost:3001/menuDB');
          set({ menuList: response.data });
        
          
        } catch (error) {
          console.error('메뉴 목록을 가져오는 데 실패했습니다:', error);
          set({ menuList: [] });
        }
      },

      getMenuId: async (id) => {
        try {
          const response = await axios.get(`http://localhost:3001/menuDB/${id}`);
          set( {...useMenuStore , menu : response.data } );
          
        } catch (error) {
          console.error('메뉴 목록을 가져오는 데 실패했습니다:', error);
          set({ menu: '' });
        }
      },


}))

export default useMenuStore