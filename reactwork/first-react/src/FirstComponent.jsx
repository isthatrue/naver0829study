import React from "react";
import './MyStyle.css';
import c5 from './C5.png';
import c8 from './C8.png';

let FirstComponent = () => {
    
    return (
        <div className="box">
            <h3>FirstComponent 컴포넌트</h3>
            <h6>public의 이미지 나타내기</h6>
            {/* public 이미지는 직접 경로로 지정해야함 - 권장안함 */}
            <img alt="" src="./C3.PNG"
            style={{border: '3px solid pink', width: '100px'}}/>
            <h6>src의 이미지 나타내기</h6>
            <img alt="" src={c5}
            style={{border: '3px solid pink', width: '100px'}}/>
            <img alt="" src={c8}
            style={{border: '3px solid pink', width: '100px', marginLeft: '10px'}}/>
        </div>
    )
}

export default FirstComponent;