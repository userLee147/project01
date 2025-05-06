import { create } from 'zustand';
import axios from 'axios';

const useOrderStore = create((set, get) => ({

    orderList : [],
    order : {},
    loading : true,
    error: null,
    getOrderList: async () => {
  
        try {
          const response = await axios.get('http://localhost:3001/orderDB');

          set({ orderList: response.data,loading : false  });
       
          
        } catch (error) {
          console.log('실패')
          set({loading: false, menuList: [] });
        }
      },

      getOrderId: async (user) => {
        set({loading : true, error : null})
        try {
          const response = await axios.get(`http://localhost:3001/orderDB/${user}`);
          set( {orderList : response.data } );
          set({loading : false})
        } catch (error) {
          console.error('예약 목록을 가져오는 데 실패했습니다:', error);
          set({ menu: '' });
          set({loading: false, menuList: [] });
        }
      },

   
      addOrder : async (data) => {

        await axios.post(`http://localhost:3001/orderDB/`,data)
        .then((res) =>  res )
        .catch((error) => error)
      }


}))

export default useOrderStore