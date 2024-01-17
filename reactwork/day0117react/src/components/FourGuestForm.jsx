import axios from "axios";
import React, { useState } from "react";

function FourGuestForm(props) {
  const [photo, setPhoto] = useState("");
  const [nickname, setNickname] = useState("");
  const [content, setContent] = useState("");

  const imageUrl =
    "https://kr.object.ncloudstorage.com/bitcamp.ncp-701/bootmyshop/";

  // 파일 업로드 이벤트
  const onUploadEvent = (event) => {
    const uploadFile = new FormData();
    uploadFile.append("upload", event.target.files[0]);

    axios({
      method: "post",
      url: "/guest/upload",
      data: uploadFile,
      headers: { "Content-Type": "multipart/form-data" },
    }).then((res) => {
      setPhoto(res.data); // 실제 스토리지에 올라간 사진 파일명 반환
    });
  };

  return (
    <div style={{ width: "400px" }}>
      <input type="file" className="form-control" onChange={onUploadEvent} />
      <img alt="" src={imageUrl + photo} width={130} />
      <b>{photo}</b>
    </div>
  );
}

export default FourGuestForm;