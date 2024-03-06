import React from 'react';


// 바이크 추가에서 브랜드 라디오 버튼의 컴포넌트
function AddbikeModelBtn({btnName, onChange, model}) {
    return (
            <>
                <input
                    id={model}
                    className='btn'
                    type='radio'
                    name={btnName}
                    value={model}
                    onChange={onChange}/>
                <label htmlFor={model} className='brandBtn'>
                    {model}
                </label>
            </>
    );
}

export default AddbikeModelBtn;