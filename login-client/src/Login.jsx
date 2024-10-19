import React, { useState } from "react";
import axios from "axios";
import {
  TextField, Button, Typography, CssBaseline, Avatar, IconButton, InputAdornment,
} from "@mui/material";
import {LoginRounded, VisibilityRounded, VisibilityOffRounded, } from "@mui/icons-material";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const [showPassword, setShowPassword] = useState(false);

  const handleClickShowPassword = () => setShowPassword((show) => !show);

  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/api/auth/login", {
        username,
        password,
      });
      setMessage(response.data);  // On success, show the message ("Hello, Name")
    } catch (error) {
      setMessage("Invalid credentials");  // On failure
    }
  };

  return (
    <div>
      <Typography variant="h3" color="primary">Login</Typography>
      <form onSubmit={handleSubmit}>
        <div>
          <TextField
            size="small"
            margin="normal"
            required
            fullWidth
            id="username"
            label="Username"
            name="username"
            autoComplete="username"
            value={username}
            onChange={(e) => {
              setUsername(e.target.value);
            }}
            autoFocus
          />
        </div>
        <div>
          <TextField
            size="small"
            margin="normal"
            required
            fullWidth
            name="password"
            label="Password"
            type={showPassword ? "text" : "password"}
            id="password"
            value={password}
            onChange={(e) => {
              setPassword(e.target.value);
            }}
            autoComplete="current-password"
            InputProps={{
              endAdornment: (
                <InputAdornment position="end">
                  <IconButton
                    aria-label="toggle password visibility"
                    onClick={handleClickShowPassword}
                    onMouseDown={handleMouseDownPassword}
                  >
                    {showPassword ? (
                      <VisibilityOffRounded />
                    ) : (
                      <VisibilityRounded />
                    )}
                  </IconButton>
                </InputAdornment>
              ),
            }}
          />
        </div>
        <Button
          type="submit"
          variant="contained"
          onClick={handleSubmit}
          sx={{ mt: 3, mb: 2 }}
          endIcon={<LoginRounded />}
        >
          Log In
        </Button>
      </form>
      <Typography variant="h4" color="primary">{message}</Typography>
    </div>
  );
};

export default Login;
