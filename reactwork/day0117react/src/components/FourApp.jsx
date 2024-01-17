import { Alert } from "@mui/material";
import FourGuestForm from "./FourGuestForm";

const FourApp = () => {
  return (
    <div>
      <Alert severity="error" variant="filled">
        <h3>FourApp-guest</h3>
      </Alert>
      <FourGuestForm />
    </div>
  );
};

export default FourApp;
