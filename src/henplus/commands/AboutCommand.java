/*
 * This is free software, licensed under the Gnu Public License (GPL)
 * get a copy from <http://www.gnu.org/licenses/gpl.html>
 * $Id: AboutCommand.java,v 1.1 2002-02-15 13:36:38 hzeller Exp $ 
 * author: Henner Zeller <H.Zeller@acm.org>
 */
package henplus.commands;

import henplus.SQLSession;
import henplus.AbstractCommand;
import henplus.Version;

/**
 * document me.
 */
public class AboutCommand extends AbstractCommand {
    final static String cpy = 
"-------------------------------------------------------------------------\n"
+" HenPlus II 0.1 Copyright(C) 1997, 2001 Henner Zeller <H.Zeller@acm.org>\n"
+" HenPlus is provided AS IS and comes with ABSOLUTELY NO WARRANTY\n"
+" This is free software, and you are welcome to redistribute it under the\n"
+" conditions of the GNU Public License <http://www.gnu.org/>\n"
+"------------------------------------------------------------------------\n";
    /**
     * returns the command-strings this command can handle.
     */
    public String[] getCommandList() {
	return new String[] {
	    "about", "version", "license"
	};
    }

    public AboutCommand() {
	System.err.print(cpy);
	System.err.println("version " + Version.getVersion());
    }

    /**
     * execute the command given.
     */
    public int execute(SQLSession session, String command) {
	if (command.startsWith("about")) {
	    System.err.print(cpy);
	}
	else if (command.startsWith("version")) {
	    System.err.println(Version.getVersion());
	}
	else if (command.startsWith("license")) {
	    System.err.println("GNU General Public License <http://www.gnu.org/licenses/gpl.txt>");
	}
	return SUCCESS;
    }

    public boolean requiresValidSession(String cmd) { 
	return false;
    }

    /**
     * return a descriptive string.
     */
    public String getShortDescription() {
	return "about HenPlus";
    }
}

/*
 * Local variables:
 * c-basic-offset: 4
 * compile-command: "ant -emacs -find build.xml"
 * End:
 */
