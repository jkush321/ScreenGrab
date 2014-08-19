// Not at all the best way to go about doing this, but it works.

#include "GarrysMod/Lua/Interface.h"
#include <stdio.h>
#include <stdlib.h>

using namespace GarrysMod::Lua;

/*

if TxtJpg("myfile.txt")!="error" then
	// it worked
end

*/

int TxtJpg( lua_State* state )
{
	if (LUA->IsType(1, Type::STRING))
	{
		const char * file = LUA->GetString(1);
		char cmd[512];
		sprintf_s(cmd,"java -jar txtjpg.jar \"garrysmod/data/%s\"",file);
		
		system(cmd);
		LUA->PushString(cmd);

		return 1;
	}

	LUA->PushString("error");

	return 1;
}

GMOD_MODULE_OPEN()
{
	LUA->PushSpecial( GarrysMod::Lua::SPECIAL_GLOB );
	LUA->PushString( "TxtJpg" );
	LUA->PushCFunction( TxtJpg );
	LUA->SetTable( -3 );

	return 0;
}

GMOD_MODULE_CLOSE()
{
	return 0;
}