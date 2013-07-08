SCRG = {}

MsgN("Initialising screengrab by Pablo")

if SERVER then
	AddCSLuaFile("cl_screengrab.lua")
	include("sv_screengrab.lua" )
else
	include( "cl_screengrab.lua" )
end