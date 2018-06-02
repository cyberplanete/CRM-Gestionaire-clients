package crm.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//Configuration login
	private Logger monLogger =Logger.getLogger(getClass().getName());
	
	//configuration pointcut déclaration pour le controleur
	@Pointcut("execution(* crm.controleur.*.*(..))")
	private void pourControleurPackage() {}
	
	//configuration pointcut déclaration pour service
	@Pointcut("execution(* crm.service.*.*(..))")
	private void pourServicePackage() {}
	
	////configuration pointcut déclaration pour DAO
	@Pointcut("execution(* crm.dao.*.*())")
	private void pourDAOPackage() {}
	
	@Pointcut("pourControleurPackage() || pourServicePackage() || pourDAOPackage()")
	private void pourControleurServiceDAO() {}
	
	//ajouter @before advice
	@Before("pourControleurServiceDAO()")
	public void before(JoinPoint unPointDeJonction) {
		
		//Afficher la méthode appelée
		String uneMethode = unPointDeJonction.getSignature().toShortString();
		monLogger.info("===========>> dans @before: Appel de la méthode: " + uneMethode);
		
		//Afficher les arguments de la méthode
		
		
		//obtenir les arguments
		Object[] args = unPointDeJonction.getArgs();
		
		//une boucle pour afficher les arguments
		for (Object unArgument : args) {
			monLogger.info("====>> argument: "+ unArgument);
		}
		
	}
	
	//Ajout @AfterReturning 
	@AfterReturning(pointcut="pourControleurServiceDAO()", returning="leResultat")
	public void afterReturning(JoinPoint unJoinPoint, Object leResultat) {
		
		String uneMethode = unJoinPoint.getSignature().toShortString();
		monLogger.info("===========>> dans @afterReturning: Appel de la méthode: " + uneMethode);
		
		//Afficher le resultat des données
		monLogger.info("======> result: " + leResultat);
		
		
		
	}
}
