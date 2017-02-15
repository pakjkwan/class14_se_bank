package serviceImpl;
import domain.ArticleBean;
import service.BoardService;
import java.util.*;
public class BoardServiceImpl implements BoardService{
	private List<ArticleBean> list;
	public BoardServiceImpl() {
		list=new ArrayList<ArticleBean>();
	}
	@Override
	public void add(ArticleBean param) {
		list.add(param);
	}

	@Override
	public ArticleBean findOne(ArticleBean param) {
		ArticleBean articleOne=new ArticleBean();
		for(ArticleBean bean:list){
			if(param.getSeq().equals(bean.getUid())){
				articleOne = bean;
				break;
			}
		}
		return articleOne;
	}

	@Override
	public List<ArticleBean> findSome(ArticleBean param) {
		List<ArticleBean> list=new ArrayList<ArticleBean>();
		for(ArticleBean temp : list){
			if(param.getSeq().equals(temp.getSeq())){
				list.add(temp);
			}
		}
		return list;
	}

	@Override
	public List<ArticleBean> list() {
		return list;
	}

	@Override
	public void update(ArticleBean param) {
		Date d = new Date();
		for(ArticleBean a : list) {
			if(param.getSeq().equals(a.getSeq())) {
				ArticleBean temp = new ArticleBean();
				temp.setContent(!param.getContent().equals(a.getContent()) ? param.getContent() : a.getContent());
				temp.setTitle(!param.getTitle().equals(a.getTitle()) ? param.getTitle() : a.getTitle());
				temp.setReadCount(String.valueOf((Integer.parseInt(a.getReadCount())+1)));
				temp.setRegdate(d.toString());
				list.set(list.indexOf(a), temp);
				break;
			}
		}
	}

	@Override
	public void delete(ArticleBean param) {
		Iterator<ArticleBean> it = list.iterator();
		while(it.hasNext()){
			if(it.next().getSeq().equals(param.getSeq())){
				it.remove();
			}
		}
	}

}
