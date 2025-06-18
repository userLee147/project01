
import '../css/modal.css'
import useUserStore from '../store/UserStore';


const Modal = ({setIsModal}) => {
const {deletUser} = useUserStore();

  return (
    <>
      <div className='modalWrap'>
        <div className='modalDiv'> 
          <div className='modalHeader' > 
            <button onClick={() => setIsModal(false)} > x </button> </div>
          <div className='modalContent' > 정말로 삭제하시겠습니까?</div>
          <div className='modalBtnDiv'>
            <button>예</button>
            <button type='button' onClick={() => setIsModal(false)}>아니오</button>
          </div>
        </div>
      </div>
    </>
  );
};

export default Modal;


