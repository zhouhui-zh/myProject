package calcite;

import org.apache.calcite.config.Lex;
import org.apache.calcite.sql.parser.SqlParser;

public class SqlParserUtil {
    public void parser(){
     SqlParser.Config config=   SqlParser.configBuilder()
             .setLex(Lex.MYSQL)//使用mysql语法
             .build();
     //SqlParser 语法解析
        SqlParser sqlParser = SqlParser.create("",config);

    }
}
