// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.

export const environment = {
  production: false,
  cookieId: "SESSIONIDAptx4869",
  cookieExpiredTime: 7,
  loginUrl: "/api/user/login",
  remembermeLoginUrl: "/api/user/rememberme",
  checkEmailUrl: "/api/user/forgetpw",
  resetPwdUrl: "/api/user/resetpw",
  registerUrl: "/api/user/register",
  testUrl: "/api/user/testConnection"
};
