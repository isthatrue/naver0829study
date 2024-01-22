import React from "react";
import img1 from "../images/1.png";
import img2 from "../images/2.png";
import img3 from "../images/3.png";
import img4 from "../images/4.png";
import img5 from "../images/5.png";
import Button from "@mui/material/Button";
import Swal from "sweetalert2";

const SweetApp = () => {
  return (
    <div>
      <h3 className="alert alert-danger">SweetAlert 사용법</h3>
      <hr />
      <Button
        variant="outlined"
        color="warning"
        onClick={() => {
          Swal.fire("안녕하세요");
        }}
      >
        기본 Alert
      </Button>
      <br />
      <Button
        variant="outlined"
        color="error"
        onClick={() => {
          Swal.fire({
            title: "Swal Test",
            html: "오늘은 즐거운<br />월요일<br />아침부터 눈이 왔어요!<br />짜증났어요!!",
            icon: "warning",
            confirmButtonText: "확인",
            confirmButtonColor: "#3085d6",
            cancelButtonText: "취소",
            cancelButtonColor: "black",
            showCancelButton: true,
          }).then((result) => {
            if (result.isConfirmed) Swal.fire("시키는대로 처리했어요!");
            else Swal.fire("취소했어요!!!");
          });
        }}
      >
        확인, 취소 Alert
      </Button>
      <br />
      <button
        type="button"
        className="btn btn-success"
        onClick={() => {
          Swal.fire({
            title: "사진 넣기",
            html: `<h5>사진 넣어볼까요!!</h5>`,
            imageUrl: img3,
            imageWidth: 70,
            imageHeight: 80,
            showCancelButton: true,
            cancelButtonText: "삭제 취소",
          });
        }}
      >
        사진 넣기
      </button>
    </div>
  );
};

export default SweetApp;
