package main

import (
	"github.com/gin-gonic/gin"
	_ "github.com/go-sql-driver/mysql"
	"main/Controller"
	"main/Middlewares"
	"net/http"
)

func main() {
	router := gin.Default()
	router.LoadHTMLGlob("Views/*.html")
	router.StaticFile("/favicon.ico", "./Views/src/favicon.ico")
	router.StaticFS("src", http.Dir("Views/src"))
	router.Handle("GET", "/", Middlewares.Auth(), Controller.MainPage)
	router.Handle("GET", "/Login", Controller.LoginPage)
	router.Handle("POST", "/Login", Controller.Login)
	router.Handle("GET", "/Register", Controller.RegisterPage)
	router.Handle("GET", "/Notice", Controller.Notice)
	router.Handle("GET", "/Setting", Middlewares.Auth(), Controller.Setting)
	router.Handle("POST", "/Setting", Middlewares.Auth(), Controller.SetSetting)
	router.Handle("POST", "/Register", Controller.Register)
	router.Handle("POST", "/LogOut", Controller.LogOut)
	router.Handle("POST", "/Favourite", Middlewares.Auth(), Controller.Favourite)
	router.Run(":80")
}
